package com.example.third.api;

import com.example.third.model.Customer;
import com.example.third.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/customers")
public class customerRessource {

    @Autowired
    private CustomerService customerService;
    @PostMapping
    public Customer addCustomer( @RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();

    }

    @GetMapping (value = "/{customerID}")
    public Customer getCustomer(@PathVariable("customerID") int customerID){
        return customerService.getCustomer(customerID);
    }

    @PutMapping (value = "/{customerID}")
    public Customer updateCustomer(@PathVariable("customerID") int customerID,@RequestBody Customer customer){
        return customerService.updateCustomer(customerID,customer);
    }

    @DeleteMapping (value = "/{customerID}")
    public void deleteCustomer(@PathVariable("customerID") int customerID){
        customerService.deleteCustomer(customerID);
    }
}
