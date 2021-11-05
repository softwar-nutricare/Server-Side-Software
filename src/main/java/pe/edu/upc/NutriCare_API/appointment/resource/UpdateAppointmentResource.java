package pe.edu.upc.NutriCare_API.appointment.resource;

import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
public class UpdateAppointmentResource {

    private Long id;
    @NotNull
    private Client client;

    @NotNull
    private String amount;

    @NotNull
    @Size(max = 16)
    private String ruc;
}
