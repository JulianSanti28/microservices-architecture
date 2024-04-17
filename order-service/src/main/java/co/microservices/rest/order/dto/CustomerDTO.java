package co.microservices.rest.order.dto;

import co.microservices.rest.order.model.Order;
import lombok.*;
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


}
