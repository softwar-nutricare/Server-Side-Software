package pe.edu.upc.NutriCare_API.profesionalProfiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.NutriCare_API.profesionalProfiles.domain.model.entity.Profesional;
import pe.edu.upc.NutriCare_API.profesionalProfiles.domain.persistence.ProfesionalRepository;
import pe.edu.upc.NutriCare_API.profesionalProfiles.domain.service.ProfesionalService;
import pe.edu.upc.NutriCare_API.shared.exception.ResourceNotFoundException;
import pe.edu.upc.NutriCare_API.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ProfesionalServiceImpl implements ProfesionalService {

    private static final String ENTITY = "Profesional";

    @Autowired
    private ProfesionalRepository profesionalRepository;

    @Autowired
    private Validator validator;

    public List<Profesional> getAll() { return profesionalRepository.findAll(); }

    @Override
    public Page<Profesional> getAll(Pageable pageable) { return profesionalRepository.findAll(pageable); }

    @Override
    public Profesional getById(Long profesionalId) {
        return profesionalRepository.findById(profesionalId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, profesionalId));
    }

    @Override
    public Profesional create(Profesional request) {
        Set<ConstraintViolation<Profesional>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return profesionalRepository.save(request);
    }

    @Override
    public Profesional update(Long profesionalId, Profesional request) {
        Set<ConstraintViolation<Profesional>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return profesionalRepository.findById(profesionalId).map(client ->
               profesionalRepository.save(
                        client.withExperience(request.getExperience()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, profesionalId));
    }

    @Override
    public ResponseEntity<?> delete(Long profesionalId) {
        return profesionalRepository.findById(profesionalId).map(client -> {
            profesionalRepository.delete(client);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, profesionalId));
    }
}
