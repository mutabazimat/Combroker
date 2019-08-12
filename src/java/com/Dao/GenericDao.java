package com.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class GenericDao<Object> {

    public String create(Object any) {
        Session s = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try {
            transaction = s.beginTransaction();
        s.save(any);
        transaction.commit();
        return "1";
        } catch (Exception e) {
            return ""+e.getMessage();
        }finally{
        s.close();
        }
    }
    public void Delete(Object any) {
        Session s = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try {
            transaction = s.beginTransaction();
        s.delete(any);
        transaction.commit();
        } catch (Exception e) {
        }finally{
            
        s.close();
        }
    }
    public String update(Object any) {
        Session s = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try {
            transaction = s.beginTransaction();
        s.update(any);
        transaction.commit();
        return "1";
        } catch (Exception e) {
            return e.getMessage();
        }finally{
            
        s.close();
        }
    }
}
