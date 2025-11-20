package yk.projects.springboottesting.services;

import yk.projects.springboottesting.dtos.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomers();

    void deleteCustomer(Long customerId);

    CustomerDTO findCustomerById(Long customerId);

    CustomerDTO updateCustomer(CustomerDTO customerDTO, Long customerId);
}
