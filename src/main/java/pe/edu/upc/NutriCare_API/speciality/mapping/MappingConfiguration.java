package pe.edu.upc.NutriCare_API.speciality.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.edu.upc.NutriCare_API.speciality.mapping.SpecialityMapper;

@Configuration("specialityMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public SpecialityMapper specialityMapper() { return new SpecialityMapper(); }
}