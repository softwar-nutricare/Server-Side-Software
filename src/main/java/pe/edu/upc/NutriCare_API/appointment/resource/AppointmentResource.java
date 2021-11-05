package pe.edu.upc.NutriCare_API.appointment.resource;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AppointmentResource {
    private Long id;
    private String client;
    private String nutritionist;
    private String diet;
    private String nutritionistNotes;
}
