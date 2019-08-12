package com.Dao;

import com.Domain.Product;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Matthew
 */
public class ProductDao extends GenericDao<Product>{
    
    public List<Product> getAllProducts() {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Product b");
        List<Product> list = q.list();
        s.close();
        return list;
    }

    public Product getOneProduct(int productId) {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Product b WHERE b.productId=?");
        q.setInteger(0, productId);
        Product one = (Product) q.uniqueResult();
        s.close();
        return one;
    }
}
