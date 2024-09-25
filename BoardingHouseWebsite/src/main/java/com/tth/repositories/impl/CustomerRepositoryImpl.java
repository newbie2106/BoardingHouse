/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories.impl;

import com.tth.pojo.Customers;
import com.tth.repositories.CustomerRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tongh
 */
@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired 
    private LocalSessionFactoryBean factory;

    @Override
    public Customers addCustomer(Customers customer) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            session.save(customer);
            return customer;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
