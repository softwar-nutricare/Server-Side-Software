package pe.edu.upc.NutriCare_API.consult.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RecipeResource {
    private Long id;
    private String recipeTitle;
    private String ingredients;
    private String preparation;
    private String calories;
}
