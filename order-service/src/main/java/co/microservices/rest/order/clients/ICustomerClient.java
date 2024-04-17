package co.microservices.rest.order.clients;

import co.microservices.rest.order.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface ICustomerClient {
    @GetMapping("/api/customer/{customerId}")
    CustomerDTO findCustomerById(@PathVariable("customerId") Long customerId);
}
