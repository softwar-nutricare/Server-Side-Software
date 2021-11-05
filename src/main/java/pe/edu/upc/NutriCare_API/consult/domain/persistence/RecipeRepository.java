package pe.edu.upc.NutriCare_API.consult.domain.persistence;

import pe.edu.upc.NutriCare_API.consult.domain.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{
}
