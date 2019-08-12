package com.Dao;

import com.Domain.Province;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class ProvinceDao extends GenericDao<Province> {

    public List<Province> getProvinces() {
//        return HibernateUtil.getSessionFactory().createCriteria(Province.class).list();

        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Province b");
        List<Province> list = q.list();
        s.close();
        return list;
    }

    public Province getOneProvince(int provinceId) {
//        return (Province) HibernateUtil.getSessionFactory().get(Province.class, provinceId);

        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Province b WHERE b.provinceId=?");
        q.setInteger(0, provinceId);
        Province one = (Province) q.uniqueResult();
        s.close();
        return one;
    }

    public Province getByName(String name) {
        Query qy = HibernateUtil.getSessionFactory().createQuery("select a from province a where name='" + name + "'");
        Province p = (Province) qy.uniqueResult();
        return p;
    }


}
