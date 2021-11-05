package pe.edu.upc.NutriCare_API.recommendation.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NutriCare_API.recommendation.domain.model.entity.Recommendation;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}
