package pe.edu.upc.NutriCare_API.diet.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NutriCare_API.diet.domain.model.entity.Diet;

@Repository
public interface DietRepository extends JpaRepository<Diet, Long> {
}
