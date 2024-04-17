package co.microservices.rest.order.service.impl;

import co.microservices.rest.order.clients.ICustomerClient;
import co.microservices.rest.order.dto.OrderDTO;
import co.microservices.rest.order.model.Order;
import co.microservices.rest.order.publisher.OrderPublisher;
import co.microservices.rest.order.repository.IOrderRepository;
import co.microservices.rest.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;

    private final ICustomerClient customerClient;

    private final OrderPublisher orderPublisher;

    @Autowired
    public OrderServiceImpl(IOrderRepository orderRepository, ICustomerClient customerClient, OrderPublisher orderPublisher){
        this.orderRepository = orderRepository;
        this.customerClient = customerClient;
        this.orderPublisher = orderPublisher;
    }

    public OrderDTO saveOrder(OrderDTO request) {
        OrderDTO orderDto = OrderDTO.toOrderDTO(this.orderRepository.save(request.toOrder()));
        this.orderPublisher.publishOrder(orderDto);
        return orderDto;
    }

    public List<OrderDTO> findAllOrders() {
        List<Order> orders = this.orderRepository.findAll();
        List<OrderDTO> ordersPojoList = orders
                .stream()
                .map(OrderDTO::toOrderDTO)
                .collect(Collectors.toList());
        ordersPojoList
                .forEach(order -> order.setCustomer(this.customerClient.findCustomerById(order.getCustomerId())));
        return ordersPojoList;
    }

    @Override
    public OrderDTO updateOrder(OrderDTO request, Long orderId) {
        return null;
    }

    @Override
    public List<OrderDTO> findAllOrdersByCustomer(Long customerId) {
        List<Order> orders = this.orderRepository.findAllByCustomerId(customerId);
        return orders
                .stream()
                .map(OrderDTO::toOrderDTO)
                .collect(Collectors.toList());
    }
}
