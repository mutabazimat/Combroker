package com.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory f = null;
    public HibernateUtil(){
        
    }
    public static Session getSessionFactory(){
        if(f==null){
            Configuration c = new Configuration().configure();
            f=c.buildSessionFactory();
        }
        return f.openSession();
    }
}
