package pe.edu.upc.NutriCare_API.recommendation.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateRecommendationResource {

    @NotNull
    @Size(max = 10)
    private String authorId;

    @NotNull
    @Size(max = 60)
    private String name;

    @NotNull
    @Size(max = 100)
    private String description;

    @NotNull
    @Size(max = 50)
    private String createdAtDate;

    @NotNull
    @Size(max = 50)
    private String lastModification;
}
