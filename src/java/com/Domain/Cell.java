package com.Domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Cell {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cellId;
    @Column( unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "sectorId")
    private Sector sector;

   @OneToMany(mappedBy = "cell")
   private List<Administrator> administrators;
   
   @OneToMany(mappedBy = "cell")
   private List<Retailer> retailers;
   
   @OneToMany(mappedBy = "cell")
   private List<Wholesaler> wholesalers;

    public Cell() {
    }

    public Cell(int cellId, String name) {
        this.cellId = cellId;
        this.name = name;
    }

    public Cell(int cellId, String name, Sector sector) {
        this.cellId = cellId;
        this.name = name;
        this.sector = sector;
    }

    

    
   

    public int getCellId() {
        return cellId;
    }

    public void setProvinceId(int cellId) {
        this.cellId = cellId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public List<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(List<Administrator> administrators) {
        this.administrators = administrators;
    }

    public List<Retailer> getRetailers() {
        return retailers;
    }

    public void setRetailers(List<Retailer> retailers) {
        this.retailers = retailers;
    }

    public List<Wholesaler> getWholesalers() {
        return wholesalers;
    }

    public void setWholesalers(List<Wholesaler> wholesalers) {
        this.wholesalers = wholesalers;
    }

    
    
    @Override
    public String toString() {
        return name ;
    }
}
