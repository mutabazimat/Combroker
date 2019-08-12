package com.Domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Matthew
 */
@Entity
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column( unique = true)
    private String name;
    @Column( unique = true)
    private String tin;
    private String address;
    private Date registeredDate;
    private Date startDate;
    private boolean status;
    
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
    
    @ManyToOne
    @JoinColumn(name="ownerId")
    private Wholesaler wholesaler;
    
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

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Wholesaler getWholesaler() {
        return wholesaler;
    }

    public void setWholesaler(Wholesaler wholesaler) {
        this.wholesaler = wholesaler;
    }
    
    public String dateDisplay(){
        return new SimpleDateFormat("dd/MM/yyyy").format(startDate);
    }

    @Override
    public String toString() {
        return  name;
    }
    
    
}
