package co.microservices.rest.customer.consumer;

import co.microservices.rest.customer.dto.OrderDTO;
import co.microservices.rest.customer.model.Customer;
import co.microservices.rest.customer.repository.ICustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    private final ObjectMapper mapper;

    private final ICustomerRepository customerRepository;

    public OrderConsumer(ObjectMapper mapper, ICustomerRepository customerRepository) {
        this.mapper = mapper;
        this.customerRepository = customerRepository;
    }

    @RabbitListener(queues = "orders")
    public void receiveOrderMessage(String order) {
        try {
            OrderDTO orderDto= this.mapper.readValue(order, OrderDTO.class);
            Customer customer = this.customerRepository.findById(orderDto.getCustomerId()).orElse(null);
            assert customer != null;
            System.out.println("Enviar correo a cliente: " + customer.getName());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

