package com.Dao;


import com.Domain.UserRole;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class UserRoleDao extends GenericDao<UserRole>{
    public List<UserRole> getAllUserRoles(){
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM UserRole b");
        List<UserRole> list = q.list();
        s.close();
        return list;
    }
    
    public UserRole getRoleById(int id){
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM UserRole b WHERE b.id=?");
        q.setInteger(0, id);
        UserRole one = (UserRole) q.uniqueResult();
        s.close();
        return one;
    }
}
