package yk.projects.springboottesting.mappers;

import yk.projects.springboottesting.dtos.CustomerDTO;
import yk.projects.springboottesting.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity fromCustomerDTO(CustomerDTO customerDTO);

    CustomerDTO fromCustomerEntity(CustomerEntity customerEntity);
}
