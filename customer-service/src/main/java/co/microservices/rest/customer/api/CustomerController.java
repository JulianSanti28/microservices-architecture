package co.microservices.rest.customer.api;

import co.microservices.rest.customer.dto.CustomerDTO;
import co.microservices.rest.customer.dto.OrderDTO;
import co.microservices.rest.customer.service.ICustomerService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
@Api(value = "Customer Management System")
public class CustomerController {
    private final ICustomerService customerService;
    CustomerController(ICustomerService customerService){
        this.customerService = customerService;
    }
    @PostMapping
    @ApiOperation(value = "Permite crear un cliente", notes = "Crea un cliente a partir de la petición DTO", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiParam(name = "request", value = "JSON con la información del cliente", required = true, type = "CustomerDTO")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "La creación es realizada correctamente", response = CustomerDTO.class), })
    public ResponseEntity<CustomerDTO> saveCustomer(@Valid @RequestBody final CustomerDTO request){
        return ResponseEntity.ok(this.customerService.saveCustomer(request));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> findAllOrdersByCustomer(@RequestParam("id") final Long customerId){
        return ResponseEntity.ok(this.customerService.findAllOrdersByCustomer(customerId));
    }
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAllCustomers(){
        return ResponseEntity.ok(this.customerService.findAllCustomer());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Long customerId){
        return ResponseEntity.ok(this.customerService.findById(customerId));
    }
}
