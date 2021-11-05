package pe.edu.upc.NutriCare_API.consult.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("requestMappingConfiguration")

public class MappingConfiguration {
    @Bean
    public RecipeMapper recipeMapper(){
        return new RecipeMapper();
    }
}
