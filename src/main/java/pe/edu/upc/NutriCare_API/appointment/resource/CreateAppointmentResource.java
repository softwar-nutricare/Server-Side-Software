package pe.edu.upc.NutriCare_API.appointment.resource;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
import pe.edu.upc.NutriCare_API.diet.domain.model.entity.Diet;
import pe.edu.upc.NutriCare_API.nutritionist.domain.model.entity.Nutritionist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
public class CreateAppointmentResource {

    @NotNull
    private Client client;

    @NotNull
    private Diet diet;

    @NotNull
    private Nutritionist nutritionist;

    @NotNull
    @Size(max = 160)
    private String nutritionistNotes;
}
