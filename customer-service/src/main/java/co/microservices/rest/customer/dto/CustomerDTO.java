package co.microservices.rest.customer.dto;

import co.microservices.rest.customer.model.Customer;
import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @Positive
    private String documentNumber;

    public Customer toCustomer(){
        return Customer
                .builder()
                .documentNumber(this.getDocumentNumber())
                .lastName(this.getLastName())
                .name(this.getName())
                .build();
    }
    public static CustomerDTO toCustomerDTO(Customer customer){
        return CustomerDTO
                .builder()
                .id(customer.getId())
                .lastName(customer.getLastName())
                .name(customer.getName())
                .documentNumber(customer.getDocumentNumber())
                .build();
    }
}
