package com.proje.odevi.model.mapper;

import com.proje.odevi.model.dto.CustomerDTO;
import com.proje.odevi.model.entity.Customer;

public class CustomerMapper {

    public  CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customer.getName());
        customerDTO.setOrders(customer.getOrders());
        return customerDTO;
    }

    public static Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setOrders(customerDTO.getOrders());
        return customer;
    }

}