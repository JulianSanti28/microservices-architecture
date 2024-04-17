package co.microservices.rest.order.service;


import co.microservices.rest.order.dto.CustomerDTO;
import co.microservices.rest.order.dto.OrderDTO;

import java.util.List;

public interface IOrderService {
    OrderDTO saveOrder(final OrderDTO request);
    List<OrderDTO> findAllOrders();
    OrderDTO updateOrder(final OrderDTO request, final Long customerId);
    List<OrderDTO> findAllOrdersByCustomer(final Long customerId);
}
