/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.Domain.Administrator;
import com.Domain.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Matthew
 */
public class AdministratorDao extends GenericDao<Administrator>{
    public List<Administrator> getAdministrators() {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Administrator b");
        List<Administrator> list = q.list();
        s.close();
        return list;
    }

    public Administrator getOneAdministrator(int id) {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Administrator b WHERE b.adminId=?");
        q.setInteger(0, (int) id);
        Administrator one = (Administrator) q.uniqueResult();
        s.close();
        return one;
    }

    public Administrator findStaffbyUsername(String email) {
        Administrator administrator;
        try {
            Session s = HibernateUtil.getSessionFactory();
            Query q = s.createQuery("SELECT u FROM Administrator u where u.email=?");
            q.setString(0, email);
            administrator = (Administrator) q.uniqueResult();
            s.close();
        } catch (Exception e) {
            administrator = null;
        }
        return administrator;
    }
}
