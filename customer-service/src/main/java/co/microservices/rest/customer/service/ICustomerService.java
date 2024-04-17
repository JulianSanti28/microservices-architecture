package co.microservices.rest.customer.service;

import co.microservices.rest.customer.dto.CustomerDTO;
import co.microservices.rest.customer.dto.OrderDTO;

import java.util.List;

public interface ICustomerService {
    CustomerDTO saveCustomer(final CustomerDTO request);
    List<CustomerDTO> findAllCustomer();
    CustomerDTO findById(Long customerId);
    CustomerDTO updateCustomer(final CustomerDTO request, final Long customerId);
    List<OrderDTO> findAllOrdersByCustomer(final Long customerId);
}
