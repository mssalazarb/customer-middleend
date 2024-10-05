package com.msf.customer.middleend.service.impl;

import com.msf.customer.middleend.client.CustomerServiceClient;
import com.msf.customer.middleend.domain.Customer;
import com.msf.customer.middleend.service.ICustomerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerServiceClient customerServiceClient;

    @Override
    @CircuitBreaker(name= "customerService", fallbackMethod = "fallbackCreateCustomer")
    public Customer createCustomer(Customer customer) {
        return customerServiceClient.createCustomer("asdas","asdasd",customer).getBody();
    }

    private ResponseEntity<String> fallbackCreateCustomer() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
    }

    @Override
    @CircuitBreaker(name= "customerService", fallbackMethod = "fallbackFindCustomerById")
    public Customer findCustomerById(Long id) {
        return customerServiceClient.findCustomerById("asdas","asdasd",id).getBody();
    }

    private ResponseEntity<String> fallbackFindCustomerById() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error obtaining  Customer");
    }
}
