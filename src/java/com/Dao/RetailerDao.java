/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;


import com.Domain.Retailer;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Matthew
 */
public class RetailerDao extends GenericDao<Retailer>{
    public List<Retailer> getAllRetailers() {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Retailer b");
        List<Retailer> list = q.list();
        s.close();
        return list;
    }

    public Retailer getOneProduct(int retailerId) {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Retailer b WHERE b.retailerId=?");
        q.setInteger(0, retailerId);
        Retailer one = (Retailer) q.uniqueResult();
        s.close();
        return one;
    }
    
    public Retailer findStaffbyUsername(String email) {
        Retailer retailer;
        try {
            Session s = HibernateUtil.getSessionFactory();
            Query q = s.createQuery("SELECT u FROM Retailer u where u.email=?");
            q.setString(0, email);
            retailer = (Retailer) q.uniqueResult();
            s.close();
        } catch (Exception e) {
            retailer = null;
        }
        return retailer;
    }
}
