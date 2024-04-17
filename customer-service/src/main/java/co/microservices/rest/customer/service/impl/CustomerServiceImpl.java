package co.microservices.rest.customer.service.impl;

import co.microservices.rest.customer.clients.IOrderClient;
import co.microservices.rest.customer.dto.CustomerDTO;
import co.microservices.rest.customer.dto.OrderDTO;
import co.microservices.rest.customer.exceptions.CustomerBadRequestException;
import co.microservices.rest.customer.model.Customer;
import co.microservices.rest.customer.repository.ICustomerRepository;
import co.microservices.rest.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository customerRepository;

    private final IOrderClient orderClient;

    @Autowired
    public CustomerServiceImpl(ICustomerRepository customerRepository, IOrderClient orderClient){
        this.customerRepository = customerRepository;
        this.orderClient = orderClient;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO request) {
        return CustomerDTO.toCustomerDTO(this.customerRepository.save(request.toCustomer()));
    }

    @Override
    public List<CustomerDTO> findAllCustomer() {
        List<Customer> customers = this.customerRepository.findAll();
        return customers
                .stream()
                .map(CustomerDTO::toCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long customerId) {
        Optional<Customer> customerOptional = this.customerRepository.findById(customerId);
        if (customerOptional.isEmpty()) throw new CustomerBadRequestException("No found customer with id: " + customerId);
        return CustomerDTO.toCustomerDTO(customerOptional.get());
    }
    @Override
    public CustomerDTO updateCustomer(CustomerDTO request, Long customerId) {
        return null;
    }

    @Override
    public List<OrderDTO> findAllOrdersByCustomer(Long customerId) {
        return this.orderClient.findAllOrdersByCustomer(customerId);
    }
}
