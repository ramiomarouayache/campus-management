package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Gestionnare;
import utils.Callback;
import utils.HibernateUtil;

public class GestionnaireDaoImpl implements GestionnaireDao{
	@Override
	public void login(String email, String password,Callback<Gestionnare> callback) {
		Gestionnare gestionnaire = null;
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			// start a transaction
			transaction = session.beginTransaction();	
			Query query = session.createQuery("from Gestionnare where email= :email and password= :password");
			// save the student object
			query.setParameter("email", email);
			query.setParameter("password", password);
			gestionnaire = (Gestionnare) query.uniqueResult();
			// commit transaction
			transaction.commit();
			//sessionFactory.close();
			callback.onSuccess(gestionnaire);
			//System.out.println(etudiant.getNom()+etudiant.getPrenom());
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			callback.onFailure(e.getMessage(),e);
			e.printStackTrace();
		}
	}

}
