package co.microservices.rest.order.dto;

import co.microservices.rest.order.model.Order;
import co.microservices.rest.order.model.enums.OrderStatusEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Builder @Getter @Setter @JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private Long id;
    private String description;
    private OrderStatusEnum orderStatus;
    private Double price;
    private Long customerId;
    private CustomerDTO customer;

    public Order toOrder(){
        return Order
                .builder()
                .orderStatus(this.getOrderStatus())
                .price(this.getPrice())
                .description(this.getDescription())
                .customerId(this.getCustomerId())
                .build();
    }
    public static OrderDTO toOrderDTO(Order order){
        return OrderDTO
                .builder()
                .id(order.getId())
                .description(order.getDescription())
                .price(order.getPrice())
                .orderStatus(order.getOrderStatus())
                .customerId(order.getCustomerId())
                .build();
    }

}
