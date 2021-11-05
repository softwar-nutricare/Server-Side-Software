package pe.edu.upc.NutriCare_API.recommendation.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.NutriCare_API.recommendation.domain.model.entity.Recommendation;
import java.util.List;

public interface RecommendationService {
    List<Recommendation> getAll();
    Page<Recommendation> getAll(Pageable pageable);
    Recommendation getById(Long recommendationId);
    Recommendation create(Recommendation recommendation);
    Recommendation update(Long recommendationId, Recommendation request);
    ResponseEntity<?> delete(Long recommendationId);
}
