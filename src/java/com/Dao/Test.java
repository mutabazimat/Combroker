/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.Domain.Administrator;

/**
 *
 * @author Matthew
 */
public class Test {
    public static void main(String[] args) {
        AdministratorDao dao = new AdministratorDao();
        Administrator admin = new Administrator();
        
        admin.setEmail("mutabazi@kalisimbi.rw");
        admin.setFirstName("Matt");
        admin.setLastName("Mutabasi");
        admin.setGender("male");
        admin.setPhoneNumber("7777");
        admin.setPassword("Matt");
        dao.create(admin);
    }
}
