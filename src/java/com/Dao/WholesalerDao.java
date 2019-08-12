package com.Dao;

import com.Domain.Wholesaler;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Matthew
 */
public class WholesalerDao extends GenericDao<Wholesaler>{
    public List<Wholesaler> getAllWholesalers() {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Wholesaler b");
        List<Wholesaler> list = q.list();
        s.close();
        return list;
    }

    public Wholesaler getOneWholesaler(int wholesalerId) {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Wholesaler b WHERE b.wholesalerId=?");
        q.setInteger(0, wholesalerId);
        Wholesaler one = (Wholesaler) q.uniqueResult();
        s.close();
        return one;
    }
    public Wholesaler findStaffbyUsername(String email) {
        Wholesaler wholesaler;
        try {
            Session s = HibernateUtil.getSessionFactory();
            Query q = s.createQuery("SELECT u FROM Wholesaler u where u.email=?");
            q.setString(0, email);
            wholesaler = (Wholesaler) q.uniqueResult();
            s.close();
        } catch (Exception e) {
            wholesaler = null;
        }
        return wholesaler;
    }
}
