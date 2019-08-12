package com.Dao;

import com.Domain.District;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class DistrictDao extends GenericDao<District>{

   public List<District> getAllDistricts() {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM District b");
        List<District> list = q.list();
        s.close();
        return list;
    }
    
    public List<District> findAllDistrictByProvince(int id) {
        Session session = HibernateUtil.getSessionFactory();
        Query query = session.createQuery("SELECT d FROM District d WHERE d.province.provinceId=?");
        query.setInteger(0, id);
        List<District> list = query.list();
        session.close();
        return list;
    }

    public District getOneDistrict(int districtId) {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM District b WHERE b.districtId=?");
        q.setInteger(0, districtId);
        District one = (District) q.uniqueResult();
        s.close();
        return one;
    }
    
    public List<District> getDistrictByPro(int provId) {
        Session session = HibernateUtil.getSessionFactory();
        Query qry = session.createQuery("from District where province=:provid");
        qry.setInteger("provid", provId);
        List<District> list = qry.list();
        session.close();
        return list;
    }
}
