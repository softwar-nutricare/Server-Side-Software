package pe.edu.upc.NutriCare_API.profesionalProfiles.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.NutriCare_API.profesionalProfiles.domain.model.entity.Profesional;

import java.util.List;

public interface ProfesionalService {
    List<Profesional> getAll();
    Page<Profesional> getAll(Pageable pageable);
    Profesional getById(Long profesionalId);
    Profesional create(Profesional profesional);
    Profesional update(Long profesionalId, Profesional request);
    ResponseEntity<?> delete(Long profesionalId);
}
