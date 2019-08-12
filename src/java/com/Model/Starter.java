package com.Model;


import com.Dao.CellDao;
import com.Dao.DistrictDao;
import com.Dao.HibernateUtil;
import com.Dao.ProvinceDao;
import com.Dao.SectorDao;
import com.Domain.Cell;
import com.Domain.District;
import com.Domain.Province;
import com.Domain.Sector;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;

public class Starter {

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        try {
            List<Province> provinces = new ArrayList<>();
            provinces.add(new Province(1,"KIGALI"));
            provinces.add(new Province(2,"EASTERN"));
            provinces.add(new Province(3,"WESTERN"));
            provinces.add(new Province(4,"NORTHERN"));
            provinces.add(new Province(5,"SOUTHERN"));
            
            for (Province pr : provinces) {
                new ProvinceDao().create(pr);
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> Province: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + pr.getName() + " created !");
            }

            List<District> districts = new ArrayList<>();
            districts.add(new District(1, "GASABO", new Province(1)));
            districts.add(new District(2, "KICUKIRO", new Province(1)));
            districts.add(new District(3, "NYARUGENGE", new Province(1)));
            
            districts.add(new District(4, "KAYONZA", new Province(2)));
            districts.add(new District(5, "RWAMAGANA", new Province(2)));
            districts.add(new District(6, "NYAGATARE", new Province(2)));
            districts.add(new District(7, "GATSIBO", new Province(2)));
            districts.add(new District(8, "KIREHE", new Province(2)));
            districts.add(new District(9, "NGOMA", new Province(2)));
            districts.add(new District(10, "BUGESERA", new Province(2)));
            
            districts.add(new District(16, "KARONGO", new Province(3)));
            districts.add(new District(12, "NGORORRERORO", new Province(3)));
            districts.add(new District(11, "NYABIHU", new Province(3)));
            districts.add(new District(13, "RUBAVU", new Province(3)));
            districts.add(new District(14, "RUSIZI", new Province(3)));
            districts.add(new District(15, "RUSIZIRUTSIRO", new Province(3)));
            districts.add(new District(17, "NYAMASHEE", new Province(3)));
            
            districts.add(new District(18, "GICUMBI", new Province(4)));
            districts.add(new District(19, "MUSANZE", new Province(4)));
            districts.add(new District(20, "BURERA", new Province(4)));
            districts.add(new District(21, "GAKENKE", new Province(4)));
            districts.add(new District(22, "RULINDO", new Province(4)));
            
            districts.add(new District(23, "HUYE", new Province(5)));
            districts.add(new District(24, "NYANZA", new Province(5)));
            districts.add(new District(25, "KAMONYI", new Province(5)));
            districts.add(new District(26, "MUHANGA", new Province(5)));
            districts.add(new District(27, "GISAGARA", new Province(5)));
            districts.add(new District(28, "NYAMAGABE", new Province(5)));
            districts.add(new District(29, "NYARUGURU", new Province(5)));
            districts.add(new District(30, "RUHANGO", new Province(5)));
            
             for (District d : districts) {
                new DistrictDao().create(d);
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> DISTRICT: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + d.getName() + " created !");
            }
             
             List<Sector> sectors =new ArrayList<>();
             sectors.add(new Sector(1, "REMERA", new District(1)));
             sectors.add(new Sector(2, "KIMIRONKO", new District(1)));
             sectors.add(new Sector(3, "BUMBOGO", new District(1)));
             sectors.add(new Sector(4, "GASTATA", new District(1)));
             sectors.add(new Sector(5, "JALI", new District(1)));
             sectors.add(new Sector(6, "NDERA", new District(1)));
             sectors.add(new Sector(7, "KIKOKERO", new District(1)));
             sectors.add(new Sector(8, "GISOZI", new District(1)));
             sectors.add(new Sector(9, "JABANA", new District(1)));
             sectors.add(new Sector(10, "KINYINYA", new District(1)));
             
             sectors.add(new Sector(11, "NIBOYI", new District(2)));
             sectors.add(new Sector(12, "MASAKA", new District(2)));
             sectors.add(new Sector(13, "GATENGA", new District(2)));
             sectors.add(new Sector(14, "KAGARAMA", new District(2)));
             sectors.add(new Sector(15, "GAHANGA", new District(2)));
             sectors.add(new Sector(16, "KANOMBE", new District(2)));
             sectors.add(new Sector(17, "GIKONDO", new District(2)));
             
             sectors.add(new Sector(19, "MUHIMA", new District(3)));
             sectors.add(new Sector(18, "MAGERAGERE", new District(3)));
             sectors.add(new Sector(20, "NYAMIRAMBO", new District(3)));
             sectors.add(new Sector(21, "NYAKABANDA", new District(3)));
             sectors.add(new Sector(22, "RWEZAMENYO", new District(3)));
             sectors.add(new Sector(23, "KIMISAGARA", new District(3)));
             
             sectors.add(new Sector(24, "NYAMIRAMA", new District(4)));
             sectors.add(new Sector(25, "MUKARANGE", new District(4)));
             sectors.add(new Sector(26, "MURUNDI", new District(4)));
             sectors.add(new Sector(27, "RWIKWAVU", new District(4)));
            
             for (Sector s : sectors) {
                new SectorDao().create(s);
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> SECTOR: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + s.getName() + " created !");
            }


            List<Cell> cells = new ArrayList<>();
            cells.add(new Cell(1, "Rukiri I", new Sector(1)));
            cells.add(new Cell(2, "Rukiri II", new Sector(1)));
            cells.add(new Cell(3, "Giporoso I", new Sector(1)));
            cells.add(new Cell(4, "Giporoso II", new Sector(1)));
            cells.add(new Cell(5, "Nyagatovu", new Sector(2)));
            cells.add(new Cell(6, "Umwezi", new Sector(2)));
            cells.add(new Cell(7, "Umucyo", new Sector(2)));
            for (Cell c : cells) {
                new CellDao().create(c);
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> CELL: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + c.getName() + " created !");
            } 
                            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> SUCCESSSSSSSS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        } catch (Exception e) {
        }
    }
    


}
