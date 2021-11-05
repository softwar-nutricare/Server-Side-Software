package pe.edu.upc.NutriCare_API.profesionalProfiles.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("profesionalMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ProfesionalMapper profesionalMapper() { return new ProfesionalMapper(); }
}
