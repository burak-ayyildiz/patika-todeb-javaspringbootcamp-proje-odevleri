package com.proje.odevi.controller;

import com.proje.odevi.model.dto.CustomerDTO;
import com.proje.odevi.model.entity.Customer;
import com.proje.odevi.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllCustomers(){
       List<Customer> allCustomers = customerService.getAllCustomers();
    return  ResponseEntity.ok(allCustomers);
    }


    @GetMapping("/{id}")
    public ResponseEntity getCustomerById(@PathVariable("id") Long id) {
        Customer byId;
        try {
            byId = customerService.getById(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping("/create")
    public ResponseEntity createNewCustomer(@RequestBody CustomerDTO customer) {
        Customer respCustomer = customerService.create(customer);
        if (respCustomer == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Customer could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respCustomer);
    }

    @DeleteMapping
    public ResponseEntity deleteCustomer(@RequestParam(name = "id") Long id) {
        try {
            customerService.delete(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Related Customer deleted successfully");
    }

    @PutMapping("/{order}")
    public ResponseEntity updateCustomer(
            @PathVariable String name,
            @RequestBody CustomerDTO customer) {
        Customer update = customerService.update(name, customer);
        if (update == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Customer could not be updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

}
