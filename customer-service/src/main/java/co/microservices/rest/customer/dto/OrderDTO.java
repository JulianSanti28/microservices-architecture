package co.microservices.rest.customer.dto;

import co.microservices.rest.customer.model.enums.OrderStatusEnum;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor @AllArgsConstructor @Builder @Getter @Setter
public class OrderDTO implements Serializable {
    private Long id;
    private String description;
    private OrderStatusEnum orderStatus;
    private Double price;
    private Long customerId;
}
