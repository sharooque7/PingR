package com.metrics.metric.controllers;


import com.metrics.metric.entities.customer.Customer;
import com.metrics.metric.services.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> getCustomer() {
        return  this.customerService.getAllCustomers();
    }
}
