package dao;

import java.sql.*;
import java.util.ArrayList;

import model.Etudiant;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Etudiant;
import utils.HibernateUtil;

public class EtudiantDao {

	String url;
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;

	public EtudiantDao() {
		/*try {
			url = "jdbc:postgresql://localhost:5432/univ_management?user=postgres&password=admin";
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	@SuppressWarnings("rawtypes")
	public Etudiant getStudentByMatricule(Long matricule) {
		Etudiant etudiant=null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			// start a transaction
			transaction = session.beginTransaction();	
			Query query = session.createQuery("from Etudiant where matricule= :matricule");
			// save the student object
			query.setParameter("matricule", matricule);
			etudiant=(Etudiant) query.uniqueResult();
			// commit transaction
			transaction.commit();
			//sessionFactory.close();
			System.out.println(etudiant.getNom()+etudiant.getPrenom());
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return etudiant;
/*		try {
			pst = (PreparedStatement) conn.createStatement();
			rs = pst.executeQuery("SELECT * FROM etudiant WHERE matricule = ?");
			pst.setLong(1, matricule);
			while (rs.next()) {
				etudiant = new Etudiant();
				etudiant.setMatricule(url);
				etudiant.setEmail(url);
				etudiant.setMatricule(url);
				etudiant.setMatricule(url);
				rs.findColumn("matricule");
				System.out.print("Column 1 returned ");
				System.out.println(rs.getString(1));
			}
			rs.close();
			st.close();*/
	}

	public Etudiant getStudentByNomEtPrenom(String nom, String prenom) {
		Etudiant etudiant=null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			// start a transaction
			transaction = session.beginTransaction();	
			Query query = session.createQuery("from Etudiant where nom= :nom and prenom= :prenom");
			// save the student object
			query.setParameter("nom", nom);
			query.setParameter("prenom", prenom);
			etudiant=(Etudiant) query.uniqueResult();
			// commit transaction
			transaction.commit();
			//sessionFactory.close();
			System.out.println(etudiant.getMatricule()+etudiant.getFormation());
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return etudiant;
	}

	public ArrayList<Etudiant> getStudentByNom(String nom) {
		ArrayList<Etudiant> etudiant=null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			// start a transaction
			transaction = session.beginTransaction();	
			Query query = session.createQuery("from Etudiant where nom= :nom");
			// save the student object
			query.setParameter("nom", nom);
			etudiant= (ArrayList<Etudiant>) query.list();
			// commit transaction
			transaction.commit();
			//sessionFactory.close();
			//System.out.println(etudiant.getNom()+etudiant.getPrenom());
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return etudiant;
	}

}
