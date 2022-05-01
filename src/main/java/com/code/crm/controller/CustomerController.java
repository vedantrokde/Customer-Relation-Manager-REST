package com.code.crm.controller;

import java.util.List;

import com.code.crm.model.Customer;
import com.code.crm.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping()
    public List<Customer> getCustomers(){
        return service.getAllCustomer();
    }
    
    @GetMapping("/{id}")
    public Customer fetch(@PathVariable int id) {
        return service.getCustomer(id);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Customer save(Customer customer){
        return service.saveCustomer(customer);
    }


    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
        service.deleteCustomer(id);
    }
}
