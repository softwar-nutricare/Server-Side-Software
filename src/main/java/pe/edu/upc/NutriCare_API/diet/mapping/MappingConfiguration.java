package pe.edu.upc.NutriCare_API.diet.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration("dietMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public DietMapper dietMapper() { return new DietMapper(); }
}
