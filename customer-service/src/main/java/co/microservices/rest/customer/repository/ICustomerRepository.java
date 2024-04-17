package co.microservices.rest.customer.repository;

import co.microservices.rest.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
