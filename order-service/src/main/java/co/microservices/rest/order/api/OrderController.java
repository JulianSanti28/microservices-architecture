package co.microservices.rest.order.api;

import co.microservices.rest.order.dto.CustomerDTO;
import co.microservices.rest.order.dto.OrderDTO;
import co.microservices.rest.order.service.IOrderService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
@Api(value = "Order Management System")
public class OrderController {
    private final IOrderService orderService;
    OrderController(IOrderService orderService){
        this.orderService = orderService;
    }
    @PostMapping
    @ApiOperation(value = "Permite crear un cliente", notes = "Crea un cliente a partir de la petición DTO", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiParam(name = "request", value = "JSON con la información del cliente", required = true, type = "CustomerDTO")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "La creación es realizada correctamente", response = CustomerDTO.class), })
    public ResponseEntity<OrderDTO> saveOrder(@Valid @RequestBody final OrderDTO request){
        return ResponseEntity.ok(this.orderService.saveOrder(request));
    }

    @GetMapping("/customer")
    public ResponseEntity<List<OrderDTO>> findAllOrdersByCustomer(@RequestParam final Long customerId){
        return ResponseEntity.ok(this.orderService.findAllOrdersByCustomer(customerId));
    }
    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAllOrders(){
        return ResponseEntity.ok(this.orderService.findAllOrders());
    }
}
