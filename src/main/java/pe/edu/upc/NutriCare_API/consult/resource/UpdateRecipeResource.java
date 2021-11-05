package pe.edu.upc.NutriCare_API.consult.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter

public class UpdateRecipeResource {

    private Long id;

    @NotNull
    @Size(max = 200)
    private String recipeTitle;

    @NotNull
    @Size(max = 500)
    private String ingredients;

    @NotNull
    @Size(max = 700)
    private String preparation;

    @NotNull
    @Size(max = 150)
    private String calories;
}
