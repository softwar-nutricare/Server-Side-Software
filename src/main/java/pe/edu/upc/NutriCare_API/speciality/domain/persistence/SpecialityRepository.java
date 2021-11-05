package pe.edu.upc.NutriCare_API.speciality.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NutriCare_API.speciality.domain.model.entity.Speciality;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
