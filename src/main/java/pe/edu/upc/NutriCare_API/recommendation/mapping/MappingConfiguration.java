package pe.edu.upc.NutriCare_API.recommendation.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("recommendationMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public RecommendationMapper recommendationMapper() { return new RecommendationMapper(); }
}
