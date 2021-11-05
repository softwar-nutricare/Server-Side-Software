package pe.edu.upc.NutriCare_API.appointment.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration("appointmentMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public AppointmentMapper appointmentMapper() { return new AppointmentMapper(); }
}
