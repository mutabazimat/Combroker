package com.Domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Generated;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Matthew
 */
@Entity
public class Wholesaler {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nationalId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    @Column(unique = true)
    private String phoneNumber;
    @Email
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRoles userRoles;
    
    @OneToMany(mappedBy = "wholesaler")
    private List<Business> businesses;
    
    @ManyToOne
    @JoinColumn(name="cellId")
    private Cell cell;
    
    @OneToMany(mappedBy = "wholesaler")
    private List<Transaction> transactions;
    
//    @OneToMany(mappedBy = "wholesaler")
//    private List<Product> products;
    
    @OneToMany(mappedBy = "wholeseler")
    private List<WholeseleBusiness> wholeseleBusinesses;

    public Wholesaler() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    public List<WholeseleBusiness> getWholeseleBusinesses() {
        return wholeseleBusinesses;
    }

    public void setWholeseleBusinesses(List<WholeseleBusiness> wholeseleBusinesses) {
        this.wholeseleBusinesses = wholeseleBusinesses;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }

    

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    
    
}
