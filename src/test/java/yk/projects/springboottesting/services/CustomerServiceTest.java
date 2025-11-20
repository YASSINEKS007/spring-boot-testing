package yk.projects.springboottesting.services;

import yk.projects.springboottesting.dtos.CustomerDTO;
import yk.projects.springboottesting.entities.CustomerEntity;
import yk.projects.springboottesting.mappers.CustomerMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import yk.projects.springboottesting.repositories.CustomerRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @Mock
    CustomerMapper customerMapper;

    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    void testGetAllUsers() {
        CustomerEntity customer = CustomerEntity.builder()
                .id(1L)
                .email("test@test.com")
                .name("customer")
                .build();

        List<CustomerEntity> customers = List.of(customer);

        when(customerMapper.fromCustomerEntity(customer)).thenReturn(CustomerDTO.builder()
                .id(1L)
                .email("test@test.com")
                .name("customer")
                .build());


        when(customerRepository.findAll()).thenReturn(customers);



        List<CustomerDTO> allCustomers = customerService.getAllCustomers();

        assertEquals(1L, allCustomers.get(0).getId());
    }

}
