package pe.edu.upc.NutriCare_API.recommendation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NutriCare_API.client.domain.service.ClientService;
import pe.edu.upc.NutriCare_API.client.mapping.ClientMapper;
import pe.edu.upc.NutriCare_API.client.resource.ClientResource;
import pe.edu.upc.NutriCare_API.client.resource.CreateClientResource;
import pe.edu.upc.NutriCare_API.client.resource.UpdateClientResource;

import pe.edu.upc.NutriCare_API.recommendation.domain.service.RecommendationService;
import pe.edu.upc.NutriCare_API.recommendation.mapping.RecommendationMapper;
import pe.edu.upc.NutriCare_API.recommendation.resource.CreateRecommendationResource;
import pe.edu.upc.NutriCare_API.recommendation.resource.RecommendationResource;
import pe.edu.upc.NutriCare_API.recommendation.resource.UpdateRecommendationResource;

@RestController
@RequestMapping("api/v1/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private RecommendationMapper mapper;

    @GetMapping
    public Page<RecommendationResource> getAllRecommendations(Pageable pageable) {
        return mapper.modelListToPage(recommendationService.getAll(), pageable);
    }

    @GetMapping("{recommendationId}")
    public RecommendationResource getRecommendationById(@PathVariable("recommendationId") Long recommendationId) {
        return mapper.toResource(recommendationService.getById(recommendationId));
    }

    @PostMapping
    public RecommendationResource createRecommendation(@RequestBody CreateRecommendationResource request) {
        return mapper.toResource(recommendationService.create(mapper.toModel(request)));
    }

    @PutMapping("{recommendationId}")
    public RecommendationResource updateRecommendation(@PathVariable Long recommendationId, @RequestBody UpdateRecommendationResource request) {
        return mapper.toResource(recommendationService.update(recommendationId, mapper.toModel(request)));
    }

    @DeleteMapping("{recommendationId}")
    public ResponseEntity<?> deleteRecommendation(@PathVariable Long recommendationId) {
        return recommendationService.delete(recommendationId);
    }


}
