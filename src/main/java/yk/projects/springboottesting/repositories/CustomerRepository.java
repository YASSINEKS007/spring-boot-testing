package yk.projects.springboottesting.repositories;

import yk.projects.springboottesting.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
