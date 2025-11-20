package yk.projects.springboottesting.services;

import yk.projects.springboottesting.dtos.CustomerDTO;
import yk.projects.springboottesting.entities.CustomerEntity;
import yk.projects.springboottesting.exceptions.CustomerNotFoundException;
import lombok.AllArgsConstructor;
import yk.projects.springboottesting.mappers.CustomerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yk.projects.springboottesting.repositories.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerMapper.fromCustomerDTO(customerDTO);
        CustomerEntity customer = customerRepository.save(customerEntity);
        return customerMapper.fromCustomerEntity(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(
                customerMapper::fromCustomerEntity
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public CustomerDTO findCustomerById(Long customerId) {
        return customerMapper.fromCustomerEntity(getCustomerEntityById(customerId));
    }

    protected CustomerEntity getCustomerEntityById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long customerId) {
        CustomerEntity customerEntity = getCustomerEntityById(customerId);
        customerEntity.setName(customerDTO.getName());
        customerEntity.setEmail(customerDTO.getEmail());
        return customerMapper.fromCustomerEntity(customerRepository.save(customerEntity));
    }
}
