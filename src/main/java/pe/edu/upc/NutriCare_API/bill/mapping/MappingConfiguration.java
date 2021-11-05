package pe.edu.upc.NutriCare_API.bill.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration("billMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public BillMapper billMapper() { return new BillMapper(); }
}
