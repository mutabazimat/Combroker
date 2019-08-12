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


@Entity
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sectorId;
    @Column( unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "districtId", nullable = false)
    private District district;
    
    @OneToMany(mappedBy = "sector")
    private List<Cell> cells;

    public Sector() {
    }

    public Sector(int sectorId) {
        this.sectorId = sectorId;
    }

    public Sector(int sectorId, String name, District district) {
        this.sectorId = sectorId;
        this.name = name;
        this.district = district;
    }
    

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    
    @Override
    public String toString() {
        return name ;
    }
}
