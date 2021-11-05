package pe.edu.upc.NutriCare_API.profesionalProfiles.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NutriCare_API.profesionalProfiles.domain.model.entity.Profesional;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {
}