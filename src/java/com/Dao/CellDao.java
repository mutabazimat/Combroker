package com.Dao;

import com.Domain.Cell;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;


public class CellDao extends GenericDao<Cell>{
    public List<Cell> getAllCells() {
//        Session s = HibernateUtil.getSessionFactory();
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Cell b");
        List<Cell> list = q.list();
        s.close();
        return list;
    }

    public Cell getOnecell(int cellId) {
        Session s = HibernateUtil.getSessionFactory();
        Query q = s.createQuery("SELECT b FROM Cell b WHERE b.cellId=?");
        q.setInteger(0, cellId);
        Cell one = (Cell) q.uniqueResult();
        s.close();
        return one;
    }
    
    public List<Cell> AllCellsBySector(int secId) {
        Session session = HibernateUtil.getSessionFactory();
        Query query = session.createQuery("SELECT c FROM Cell c WHERE c.sector.sectorId=?");
        query.setInteger(0, secId);
        List<Cell> list = query.list();
        session.close();
        return list;
    }
}
