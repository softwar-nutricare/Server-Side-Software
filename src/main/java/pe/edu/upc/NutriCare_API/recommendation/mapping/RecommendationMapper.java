package pe.edu.upc.NutriCare_API.recommendation.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
import pe.edu.upc.NutriCare_API.client.resource.ClientResource;
import pe.edu.upc.NutriCare_API.client.resource.CreateClientResource;
import pe.edu.upc.NutriCare_API.client.resource.UpdateClientResource;
import pe.edu.upc.NutriCare_API.recommendation.domain.model.entity.Recommendation;
import pe.edu.upc.NutriCare_API.recommendation.resource.CreateRecommendationResource;
import pe.edu.upc.NutriCare_API.recommendation.resource.RecommendationResource;
import pe.edu.upc.NutriCare_API.recommendation.resource.UpdateRecommendationResource;
import pe.edu.upc.NutriCare_API.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class RecommendationMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public RecommendationResource toResource(Recommendation model) { return mapper.map(model, RecommendationResource.class); }

    public Page<RecommendationResource> modelListToPage(List<Recommendation> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, RecommendationResource.class), pageable, modelList.size());
    }

    public Recommendation toModel(CreateRecommendationResource resource) {
        return mapper.map(resource, Recommendation.class);
    }

    public Recommendation toModel(UpdateRecommendationResource resource) { return mapper.map(resource, Recommendation.class); }
}
