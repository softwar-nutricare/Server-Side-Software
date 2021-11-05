package pe.edu.upc.NutriCare_API.nutritionist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.NutriCare_API.nutritionist.domain.model.entity.Nutritionist;
import pe.edu.upc.NutriCare_API.nutritionist.domain.persistence.NutritionistRepository;
import pe.edu.upc.NutriCare_API.nutritionist.domain.service.NutritionistService;
import pe.edu.upc.NutriCare_API.shared.exception.ResourceNotFoundException;
import pe.edu.upc.NutriCare_API.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class NutritionistServiceImpl implements NutritionistService {

    private static final String ENTITY = "Nutritionist";

    @Autowired
    private NutritionistRepository nutritionistRepository;

    @Autowired
    private Validator validator;

    public List<Nutritionist> getAll() { return nutritionistRepository.findAll(); }

    @Override
    public Page<Nutritionist> getAll(Pageable pageable) { return nutritionistRepository.findAll(pageable); }

    @Override
    public Nutritionist getById(Long nutritionistId) {
        return nutritionistRepository.findById(nutritionistId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, nutritionistId));
    }

    @Override
    public Nutritionist create(Nutritionist request) {
        Set<ConstraintViolation<Nutritionist>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return nutritionistRepository.save(request);
    }

    @Override
    public Nutritionist update(Long nutritionistId, Nutritionist request) {
        Set<ConstraintViolation<Nutritionist>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return nutritionistRepository.findById(nutritionistId).map(client ->
                nutritionistRepository.save(
                        client.withUsername(request.getUsername())
                                .withPassword(request.getPassword())
                                .withFirstName(request.getFirstName())
                                .withLastName(request.getLastName())
                                .withEmail(request.getEmail())
                                .withCnpNumber(request.getCnpNumber()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, nutritionistId));
    }

    @Override
    public ResponseEntity<?> delete(Long nutritionistId) {
        return nutritionistRepository.findById(nutritionistId).map(client -> {
            nutritionistRepository.delete(client);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, nutritionistId));
    }
}
