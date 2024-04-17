package co.microservices.rest.order.repository;

import co.microservices.rest.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCustomerId(Long customerId);
}
