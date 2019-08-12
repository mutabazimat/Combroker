
package com.Dao;


import com.Domain.User;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author 
 */
public class LoginDao {

    public User login(String username) {
        User user;
        try {
            Session session = HibernateUtil.getSessionFactory();
            Query query = session.createQuery("SELECT c FROM User c WHERE c.username=?");
            query.setString(0, username);
            user = (User) query.uniqueResult();
            session.close();
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

}
