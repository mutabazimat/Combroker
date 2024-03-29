/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Matthew
 */
@Entity
public class WholeseleBusiness {
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column( unique = true)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "businessId")
    private Business business;
    
    @ManyToOne
    @JoinColumn(name = "sholeserId")
    private Wholesaler wholeseler;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Wholesaler getWholeseler() {
        return wholeseler;
    }

    public void setWholeseler(Wholesaler wholeseler) {
        this.wholeseler = wholeseler;
    }
    
}
