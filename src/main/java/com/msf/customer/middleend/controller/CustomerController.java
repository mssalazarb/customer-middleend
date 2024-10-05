package com.msf.customer.middleend.controller;

import com.msf.customer.middleend.domain.Customer;
import com.msf.customer.middleend.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Customer> createCustomer(@RequestBody  Customer customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<Customer> findcustomerById(@RequestParam Long id) {
        return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK);
    }

}
