package pe.edu.upc.NutriCare_API.diet.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateDietResource {

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    @Size(max = 100)
    private String description;

    @NotNull
    @Size(max = 50)
    private String createdAtDate;
}
