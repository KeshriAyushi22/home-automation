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



private static Session session;



public static Session getSession() {
	return session==null?HibernateUtil.getSessionFactory().openSession():session;

}



public static void saveData(Object req) {
		 session =getSession();
			Transaction tx = session.beginTransaction();
           
			session.save(req);
			tx.commit();
			session.close();  
		}

public static LoginDetails getDetails(LoginDetails request){
	 session = getSession();
   Criteria criteria= session.createCriteria(LoginDetails.class);
   criteria.add(Restrictions.eq("email", request.getEmail()));
   criteria.add(Restrictions.eq("password", request.getPassword()));
    LoginDetails  obj = (LoginDetails) criteria.uniqueResult();
	return obj;
}
public static LoginDetails getActivationDetails(String email,String token){
	 session = getSession();
   Criteria criteria= session.createCriteria(LoginDetails.class);
   criteria.add(Restrictions.eq("email", email));
   criteria.add(Restrictions.eq("passwordToken", token));
   LoginDetails  obj = (LoginDetails) criteria.uniqueResult();
	return obj;
}



public static LoginDetails getEmailDetails(String emailId) {
	 session =getSession();
	   Criteria criteria= session.createCriteria(LoginDetails.class);
	   criteria.add(Restrictions.eq("email", emailId));
	  
	   LoginDetails  obj = (LoginDetails) criteria.uniqueResult();
		return obj;
}


}
