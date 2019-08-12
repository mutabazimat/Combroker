package com.Dao;

import com.Domain.Sector;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;


public class SectorDao extends GenericDao<Sector>{
    public List<Sector> getAllSectors() {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Sector b");
        List<Sector> list = q.list();
        s.close();
        return list;
    }

    public Sector getOneSector(int sectorId) {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Sector b WHERE b.sectorId=?");
        q.setInteger(0, sectorId);
        Sector one = (Sector) q.uniqueResult();
        s.close();
        return one;
    }
    
    public List<Sector> AllSectorByDistrict(int disId) {
        Session session = HibernateUtil.getSessionFactory();
        Query query = session.createQuery("SELECT c FROM Sector c WHERE c.district.districtId=?");
        query.setInteger(0, disId);
        List<Sector> list = query.list();
        session.close();
        return list;
    }
}
