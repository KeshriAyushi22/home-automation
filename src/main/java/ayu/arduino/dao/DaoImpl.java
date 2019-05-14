package ayu.arduino.dao;




import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.criterion.Restrictions;


import ayu.arduino.service.Activation;
import ayu.arduino.to.ApiRequest;
import ayu.arduino.to.LoginDetails;
import ayu.arduino.to.Mail;
import ayu.arduino.util.HibernateUtil;



public class DaoImpl implements Serializable{
	private static final long serialVersionUID = 1L;





	public static void saveOrUpdate(Object req) {
		Session session =HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.saveOrUpdate(req);
		tx.commit();
		session.close();  
	}

	public static LoginDetails getDetails(LoginDetails request){
		Session session=null;
		LoginDetails obj=null;
		try {
			session =HibernateUtil.getSessionFactory().openSession();
			Criteria criteria= session.createCriteria(LoginDetails.class);
			criteria.add(Restrictions.eq("email", request.getEmail()));
			criteria.add(Restrictions.eq("password", request.getPassword()));
			obj = (LoginDetails) criteria.uniqueResult();
		}catch(Exception e) {
			System.out.println(e); 
		}finally {
			session.close();
		}

		return obj;
	}
	public static LoginDetails getActivationDetails(String email,String token){
		Session session=null;
		LoginDetails obj=null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria= session.createCriteria(LoginDetails.class);
			criteria.add(Restrictions.eq("email", email));
			criteria.add(Restrictions.eq("passwordToken", token));
			obj = (LoginDetails) criteria.uniqueResult();
		}catch(Exception e) {
			System.out.println(e); 
		}finally {
			session.close();
		}

		return obj;
	}



	public static LoginDetails getEmailDetails(String emailId) {
		Session session=null;
		LoginDetails obj=null;
		try{
			session =HibernateUtil.getSessionFactory().openSession();
			Criteria criteria= session.createCriteria(LoginDetails.class);
			criteria.add(Restrictions.eq("email", emailId));

			obj = (LoginDetails) criteria.uniqueResult();
		}catch(Exception e) {
			System.out.println(e); 
		}finally {
			session.close();
		}
		return obj;
	}


}
