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
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int districtId;
    @Column( unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "provinceId", nullable = false)
    private Province province;
    @OneToMany(mappedBy = "province")
     private List<District> districts;
    
    @OneToMany(mappedBy = "district")
    private List<Sector> sectors;

    public District() {
    }

    public District(int districtId) {
        this.districtId = districtId;
    }

    public District(int districtId, String name) {
        this.districtId = districtId;
        this.name = name;
    }

    public District(int districtId, String name, Province province) {
        this.districtId = districtId;
        this.name = name;
        this.province = province;
    }
    

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }
    @Override
    public String toString() {
        return name ;
    }
    
}
