
package com.Dao;

import com.Domain.Business;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Matthew
 */
public class BusinessDao extends GenericDao<Business>{
    public List<Business> getAllBusinesses() {
//        Session s = HibernateUtil.getSessionFactory();
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Business b");
        List<Business> list = q.list();
        s.close();
        return list;
    }

    public Business getOneBusiness(int cellId) {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Business b WHERE b.cellId=?");
        q.setInteger(0, cellId);
        Business one = (Business) q.uniqueResult();
        s.close();
        return one;
    }
    
//    public List<Business> AllCellsBySector(int secId) {
//        Session session = HibernateUtil.getSessionFactory();
//        Query query = session.createQuery("SELECT c FROM Cell c WHERE c.sector.sectorId=?");
//        query.setInteger(0, secId);
//        List<Cell> list = query.list();
//        session.close();
//        return list;
//    }
}
