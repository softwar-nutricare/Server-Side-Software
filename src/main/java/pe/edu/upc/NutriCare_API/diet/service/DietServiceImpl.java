package pe.edu.upc.NutriCare_API.diet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.NutriCare_API.diet.domain.model.entity.Diet;
import pe.edu.upc.NutriCare_API.diet.domain.persistence.DietRepository;
import pe.edu.upc.NutriCare_API.diet.domain.service.DietService;
import pe.edu.upc.NutriCare_API.shared.exception.ResourceNotFoundException;
import pe.edu.upc.NutriCare_API.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class DietServiceImpl implements DietService {

    private static final String ENTITY = "Diet";

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private Validator validator;

    public List<Diet> getAll() { return dietRepository.findAll(); }

    @Override
    public Page<Diet> getAll(Pageable pageable) {
        return dietRepository.findAll(pageable);
    }

    @Override
    public Diet getById(Long dietId) {
        return dietRepository.findById(dietId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, dietId));
    }

    @Override
    public Diet create(Diet request) {
        Set<ConstraintViolation<Diet>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return dietRepository.save(request);
    }

    @Override
    public Diet update(Long dietId, Diet request) {
        Set<ConstraintViolation<Diet>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return dietRepository.findById(dietId).map(diet ->
                dietRepository.save(
                        diet.withName(request.getName())
                                .withDescription(request.getDescription())
                                .withCreatedAtDate(request.getCreatedAtDate()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, dietId));
    }

    @Override
    public ResponseEntity<?> delete(Long dietId) {
        return dietRepository.findById(dietId).map(diet -> {
            dietRepository.delete(diet);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, dietId));
    }
}
