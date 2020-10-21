package com.example.third.service;

import com.example.third.dao.CustomerDao;
import com.example.third.exception.CustomerNotFoundException;
import com.example.third.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();
    private  int customerIDCount =1;
    public Customer addCustomer(Customer customer){
        return customerDao.save(customer);
    }

    public List<Customer> getCustomers(){
        return customerDao.findAll();
    }

    public Customer getCustomer(int customerID){
        Optional<Customer> optionalCustomer= customerDao.findById(customerID);
        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Customer Record is not available");
        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerID, Customer customer){
        customer.setCustomerID(customerID);
        return customerDao.save(customer);
    }

    public void deleteCustomer(int customerID){
        customerDao.deleteById(customerID);
    }
}
