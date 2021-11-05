package pe.edu.upc.NutriCare_API.nutritionist.resource;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateNutritionistResource {

    @NotNull
    @Size(max = 16)
    private String username;

    @NotNull
    @Size(max = 60)
    private String password;

    @NotNull
    @Size(max = 50)
    private String firstName;

    @NotNull
    @Size(max = 50)
    private String lastName;

    @NotNull
    @Size(max = 50)
    private String email;

    @NotNull
    @Size(min = 6, max = 12)
    private String cnpNumber;
}
