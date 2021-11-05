package pe.edu.upc.NutriCare_API.appointment.resource;

import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
@Getter
@Setter
public class AppointmentResource {
    private Long id;
    private String nutritionistNotes;
}
