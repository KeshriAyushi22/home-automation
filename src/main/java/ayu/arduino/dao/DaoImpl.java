package ayu.arduino.dao;




import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ayu.arduino.to.ApiRequest;
import ayu.arduino.to.LoginDetails;
import ayu.arduino.util.HibernateUtil;



public class DaoImpl implements Serializable{
private static final long serialVersionUID = 1L;

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

}
