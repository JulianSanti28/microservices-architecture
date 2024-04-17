package co.microservices.rest.order.model;

import co.microservices.rest.order.model.enums.OrderStatusEnum;
import lombok.*;

import javax.persistence.*;

@Table(name = "orders")@Entity @Builder @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;
    private Double price;
    private Long customerId;
}
