package com.msf.customer.middleend.client;

import com.msf.customer.middleend.domain.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient( url = "${microservices.url}/api/v1/customer-service/customers" ,name = "customer-service")  //permite establecer al servicio que nos vamos a comunicar
public interface CustomerServiceClient {

    @PostMapping
    ResponseEntity<Customer> createCustomer  (@RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                            @RequestHeader(value = "x-sw-client-user-agent", required = true) String xCmClientUserAgent,
                                            @RequestBody Customer customer);

    @GetMapping
    ResponseEntity<Customer> findCustomerById  (@RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                              @RequestHeader(value = "x-sw-client-user-agent", required = true) String xCmClientUserAgent,
                                              @RequestParam Long id);

}
