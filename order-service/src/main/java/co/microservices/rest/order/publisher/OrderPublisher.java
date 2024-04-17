package co.microservices.rest.order.publisher;
import co.microservices.rest.order.dto.OrderDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderPublisher {

    private final RabbitTemplate rabbitTemplate;

    private static final String QUEUE_NAME = "orders";

    @Autowired
    public OrderPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishOrder(Object orderDTO) {
        rabbitTemplate.convertAndSend(QUEUE_NAME, orderDTO);
    }
}

