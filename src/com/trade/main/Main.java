package com.trade.main;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.trade.hibernate.model.LoginInfo;
import com.trade.hibernate.util.HibernateUtil;

public class Main {

       public Integer addNewUser(){
        // Add new user
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer userId = null;
        try{
            tx = session.beginTransaction();
            LoginInfo emp = new LoginInfo();
            emp.setUserName("kill");
            emp.setPassword("bill");
            emp.setFirstName("Karthik");
            emp.setLastName("Musunur");
            emp.setEmail("kval@gmail.com");
            userId = (Integer) session.save(emp); 
            tx.commit();
         }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
         }finally {
            session.close(); 
            //terminate session factory, otherwise program won't end
            sessionFactory.close();
            System.out.println(userId+" customerId"); 
         
         }
        return userId;
       }
        
       // verify if user exists and get user details
       public static LoginInfo verifyUser(String userName, String password){
    	   SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
           Session session = sessionFactory.openSession();
           LoginInfo loginInfo = new LoginInfo();
           Transaction tx = null;
           try{
        	   tx = session.beginTransaction();
        	   Criteria cr = session.createCriteria(LoginInfo.class);
               // Add restriction.
               cr.add(Restrictions.eq("userName", userName));
               cr.add(Restrictions.eq("password",password));
               loginInfo = (LoginInfo) cr.uniqueResult();
               
           }catch (HibernateException e) {
               if (tx!=null) tx.rollback();
               e.printStackTrace(); 
           }finally {
               session.close(); 
               sessionFactory.close();
           }
           
       return loginInfo;    
       }
       
       
       // update the userInfo
       public static LoginInfo updateUser(LoginInfo userInfo){
    	   SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
           Session session = sessionFactory.openSession();
           LoginInfo loginInfo = new LoginInfo();
           Transaction tx = null;
           try{
        	   tx = session.beginTransaction();
        	   String hql = "UPDATE LoginInfo set FIRST_NAME = :firstName,"+ 
        	             	"LAST_NAME = :lastName,"+
        	             	"EMAIL = :email WHERE id = :ido";
	           Query query = session.createQuery(hql);
	           query.setParameter("firstName", userInfo.getFirstName());
	           query.setParameter("lastName", userInfo.getLastName());
	           query.setParameter("email", userInfo.getEmail());
	           query.setParameter("ido", userInfo.getId());
	           int result = query.executeUpdate();
	           System.out.println("result "+result);
               
           }catch (HibernateException e) {
               if (tx!=null) tx.rollback();
               e.printStackTrace(); 
           }finally {
               session.close(); 
               sessionFactory.close();
           }
           
       return loginInfo;    
       }
       
         public static void main(String[] args) {
        	 LoginInfo loginInfo = new LoginInfo();
        	 loginInfo.setFirstName("karthik");
        	 loginInfo.setLastName("musunur");
        	 loginInfo.setEmail("kvallie@gmail.com");
        	 loginInfo.setId(4);
        	 
        	 LoginInfo loginInfo1 = updateUser(loginInfo);
        	 System.out.println(loginInfo1.getEmail());
        	
         }
        /*
        Amazon Store Card 6045 7810 9433 2243*/
    
}
