package ayu.arduino.dao;




import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import ayu.arduino.service.Activation;
import ayu.arduino.to.ApiRequest;
import ayu.arduino.to.LoginDetails;
import ayu.arduino.to.Mail;
import ayu.arduino.util.HibernateUtil;



public class DaoImpl implements Serializable{
private static final long serialVersionUID = 1L;

@Autowired 
private static SessionFactory sessionFactory;
private static Session session;
private static Session currentSession() {
	return sessionFactory.getCurrentSession();
}

public static void saveData(Object req) {
		Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
            
			session.save(req);
			tx.commit();
			session.close();  
		}

public static LoginDetails getDetails(LoginDetails request){
	Session session = HibernateUtil.getSessionFactory().openSession();
   Criteria criteria= session.createCriteria(LoginDetails.class);
   criteria.add(Restrictions.eq("email", request.getEmail()));
    LoginDetails  obj = (LoginDetails) criteria.uniqueResult();
	return obj;
}
public static LoginDetails getActivationDetails(String request){
	Session session = HibernateUtil.getSessionFactory().openSession();
   Criteria criteria= session.createCriteria(LoginDetails.class);
   criteria.add(Restrictions.eq("email", request));
   LoginDetails  obj = (LoginDetails) criteria.uniqueResult();
	return obj;
}

public static void save(Object req) {
	//Session session = null;
	try {
		session = currentSession();
		session.save(req);
	} catch (Exception edae) {
		System.out.println(edae);
		}
	}


}
