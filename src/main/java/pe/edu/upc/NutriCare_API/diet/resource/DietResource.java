package pe.edu.upc.NutriCare_API.diet.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DietResource {
    private Long id;
    private String name;
    private String description;
    private String createdAtDate;
}
