package com.code.crm.service;

import java.util.List;

import com.code.crm.dao.CustomerRepo;
import com.code.crm.model.Customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepo repo;

    public CustomerService(CustomerRepo repo) {
        this.repo = repo;
    }
    public List<Customer> getAllCustomer() {
        return repo.findAll();
    }
    public Customer getCustomer(int id) {
        return repo.findById(id).orElse(new Customer());
    }
    public Customer saveCustomer(Customer customer) {
        return repo.save(customer);
    }
    public void deleteCustomer(int id) {
        repo.deleteById(id);
    }
}
