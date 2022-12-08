package dao;

import java.sql.*;
import java.util.ArrayList;

import model.Etudiant;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Etudiant;
import utils.Callback;
import utils.HibernateUtil;

public class EtudiantDaoImpl implements EtudiantDao{


	public EtudiantDaoImpl() {
		
	}
	@Override
	@SuppressWarnings("rawtypes")
	public void getStudentByMatricule(Long matricule,Callback<Etudiant> callback) {
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
			System.out.println(etudiant.toString());
			transaction.commit();
			//sessionFactory.close();
			callback.onSuccess(etudiant);
			//System.out.println(etudiant.getNom()+etudiant.getPrenom());
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			callback.onFailure(e.getMessage(),e);
			e.printStackTrace();
		}
	}

	@Override
	public void getStudentByNomEtPrenom(String nom, String prenom,Callback<Etudiant> callback) {
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
			System.out.println(etudiant.toString());
			transaction.commit();
			//sessionFactory.close();
			callback.onSuccess(etudiant);
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			callback.onFailure(e.getMessage(),e);
			e.printStackTrace();
		}
	}

	@Override
	public void getStudentByNom(String nom,Callback<ArrayList<Etudiant>> callback) {
		ArrayList<Etudiant> etudiants=null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			// start a transaction
			transaction = session.beginTransaction();	
			Query query = session.createQuery("from Etudiant where nom= :nom");
			// save the student object
			query.setParameter("nom", nom);
			etudiants= (ArrayList<Etudiant>) query.list();
			// commit transaction
			System.out.println(etudiants.toString());
			transaction.commit();
			//sessionFactory.close();
			callback.onSuccess(etudiants);
			//System.out.println(etudiant.getNom()+etudiant.getPrenom());
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			callback.onFailure(e.getMessage(),e);
			e.printStackTrace();
		}
	}

	@Override
	public void getAllStudents(Callback<ArrayList<Etudiant>> callback) {
		// TODO Auto-generated method stub
		ArrayList<Etudiant> etudiants=null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			// start a transaction
			transaction = session.beginTransaction();	
			Query query = session.createQuery("from Etudiant");
			// save the student object
			etudiants= (ArrayList<Etudiant>) query.list();
			// commit transaction
			System.out.println(etudiants.get(0).toString());
			transaction.commit();
			//sessionFactory.close();
			callback.onSuccess(etudiants);
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Boolean addStudent(Etudiant etudiant) {
		Transaction transaction = null;
		System.out.println("insideDAO");
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			System.out.println("begintransaction");
			// start a transaction
			transaction = session.beginTransaction();	
			session.save(etudiant);
			// commit transaction
			transaction.commit();
			//sessionFactory.close();
			return true;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Boolean updateStudent(Etudiant etudiant) {
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			// start a transaction
			transaction = session.beginTransaction();	
			session.update(etudiant);
			// commit transaction
			transaction.commit();
			//sessionFactory.close();
			return true;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Boolean deleteStudent(Long matricule) {
		return false;
	}
	

}
