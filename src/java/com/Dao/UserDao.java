package com.Dao;


import com.Domain.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class UserDao extends GenericDao<User> {

    public String createUser(User user) {
        try {
            HibernateUtil.getSessionFactory().save(user);
            return "User saved";
        } catch (Exception e) {
            return "Failed to save";
        }
    }

    public List<User> getUsers() {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM User b");
        List<User> list = q.list();
        s.close();
        return list;
    }

    public User getOneUser(long userId) {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM User b WHERE b.userId=?");
        q.setInteger(0, (int) userId);
        User one = (User) q.uniqueResult();
        s.close();
        return one;
    }

    public User findStaffbyUsername(String email) {
        User user;
        try {
            Session s = HibernateUtil.getSessionFactory();
            Query q = s.createQuery("SELECT u FROM User u where u.email=?");
            q.setString(0, email);
            user = (User) q.uniqueResult();
            s.close();
        } catch (Exception e) {
            user = null;
        }
        return user;
    }
}
