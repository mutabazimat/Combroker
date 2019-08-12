package com.Domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int provinceId;
    @Column( unique = true)
    @NotBlank(message="Name required")
    private String name;
    @OneToMany(mappedBy = "province")
     private List<District> districts;

    public Province() {
    }

    public Province(int provinceId) {
        this.provinceId = provinceId;
    }

    public Province(int provinceId, String name) {
        this.provinceId = provinceId;
        this.name = name;
    }
    
    

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    @Override
    public String toString() {
        return name ;
    }
    
}
