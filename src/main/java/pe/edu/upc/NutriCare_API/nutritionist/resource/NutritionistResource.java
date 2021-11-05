package pe.edu.upc.NutriCare_API.nutritionist.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NutritionistResource {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String cnpNumber;
}