package pe.edu.upc.NutriCare_API.recommendation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pe.edu.upc.NutriCare_API.recommendation.domain.model.entity.Recommendation;
import pe.edu.upc.NutriCare_API.recommendation.domain.persistence.RecommendationRepository;
import pe.edu.upc.NutriCare_API.recommendation.domain.service.RecommendationService;
import pe.edu.upc.NutriCare_API.shared.exception.ResourceNotFoundException;
import pe.edu.upc.NutriCare_API.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private static final String ENTITY = "Recommendation";

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private Validator validator;

    public List<Recommendation> getAll() { return recommendationRepository.findAll(); }

    @Override
    public Page<Recommendation> getAll(Pageable pageable) {
        return recommendationRepository.findAll(pageable);
    }

    @Override
    public Recommendation getById(Long recommendationId) {
        return recommendationRepository.findById(recommendationId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, recommendationId));
    }

    @Override
    public Recommendation create(Recommendation request) {
        Set<ConstraintViolation<Recommendation>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return recommendationRepository.save(request);
    }

    @Override
    public Recommendation update(Long recommendationId, Recommendation request) {
        Set<ConstraintViolation<Recommendation>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return recommendationRepository.findById(recommendationId).map(recommendation ->
                recommendationRepository.save(
                        recommendation.withAuthorId(request.getAuthorId())
                                .withName(request.getName())
                                .withDescription(request.getDescription())
                                .withCreatedAtDate(request.getCreatedAtDate())
                                .withLastModification(request.getLastModification()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, recommendationId));
    }

    @Override
    public ResponseEntity<?> delete(Long recommendationId) {
        return recommendationRepository.findById(recommendationId).map(recommendation -> {
            recommendationRepository.delete(recommendation);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, recommendationId));
    }
}
