package pe.edu.upc.NutriCare_API.recommendation.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecommendationResource {
    private Long id;
    private String authorId;
    private String name;
    private String description;
    private String createdAtDate;
    private String lastModification;
}
