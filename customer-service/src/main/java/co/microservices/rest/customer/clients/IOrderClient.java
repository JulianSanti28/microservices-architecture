package co.microservices.rest.customer.clients;

import co.microservices.rest.customer.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient(name = "order-service")
public interface IOrderClient {
    @GetMapping("/api/order/customer")
    List<OrderDTO> findAllOrdersByCustomer(@RequestParam("customerId") Long customerId);
}
