package com.proje.odevi.service;

import com.proje.odevi.model.dto.CustomerDTO;
import com.proje.odevi.model.entity.Customer;
import com.proje.odevi.model.mapper.CustomerMapper;
import com.proje.odevi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        List <Customer> allCustomers = customerRepository.findAll();
    return allCustomers;
    }

    public Customer getById(Long id){
        Optional<Customer> byId = customerRepository.findById(id);
        return byId.orElseThrow(() -> new RuntimeException("Customer not found!"));
    }

    public Customer create(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.toEntity(customerDTO);
            return customerRepository.save(customer);

        }

    public void delete(Long id) {
        getById(id);
        customerRepository.deleteById(id);
    }

    public Customer update(String name, CustomerDTO customer) {
        Optional<Customer> customerByName = customerRepository.findCustomerByName(name);
        if (!customerByName.isPresent())
            return null;
        Customer updatedCustomer = customerByName.get();
        if (!StringUtils.isEmpty(customer.getName())) {
            updatedCustomer.setName(customer.getName());
        }
        if (!StringUtils.isEmpty(customer.getName())) {
            updatedCustomer.setName(customer.getName());
        }

        return customerRepository.save(updatedCustomer);
    }
}
