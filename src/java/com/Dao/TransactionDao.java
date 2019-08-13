package com.Dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.Domain.Transaction;

/**
 *
 * @author Matthew
 */
public class TransactionDao extends GenericDao<Transaction>{
    public List<Transaction> getTransations() {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Transaction b");
        List<Transaction> list = q.list();
        s.close();
        return list;
    }

    public Transaction getOneTransation(int id) {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Transation b WHERE b.tranctionId=?");
        q.setInteger(0, (int) id);
        Transaction one = (Transaction) q.uniqueResult();
        s.close();
        return one;
    }


}
