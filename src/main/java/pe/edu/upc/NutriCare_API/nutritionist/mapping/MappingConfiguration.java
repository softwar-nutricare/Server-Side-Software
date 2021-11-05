package pe.edu.upc.NutriCare_API.nutritionist.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("nutritionistMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public NutritionistMapper nutritionistMapper() { return new NutritionistMapper(); }
}