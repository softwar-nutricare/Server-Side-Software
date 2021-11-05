package pe.edu.upc.NutriCare_API.nutritionist.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NutriCare_API.nutritionist.domain.model.entity.Nutritionist;

@Repository
public interface NutritionistRepository extends JpaRepository<Nutritionist, Long> {
}
