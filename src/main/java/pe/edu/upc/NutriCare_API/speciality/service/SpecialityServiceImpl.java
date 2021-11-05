package pe.edu.upc.NutriCare_API.speciality.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.NutriCare_API.speciality.domain.model.entity.Speciality;
import pe.edu.upc.NutriCare_API.speciality.domain.persistence.SpecialityRepository;
import pe.edu.upc.NutriCare_API.speciality.domain.service.SpecialityService;
import pe.edu.upc.NutriCare_API.shared.exception.ResourceNotFoundException;
import pe.edu.upc.NutriCare_API.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    private static final String ENTITY = "Speciality";

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private Validator validator;

    public List<Speciality> getAll() { return specialityRepository.findAll(); }

    @Override
    public Page<Speciality> getAll(Pageable pageable) { return specialityRepository.findAll(pageable); }

    @Override
    public Speciality getById(Long specialityId) {
        return specialityRepository.findById(specialityId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, specialityId));
    }

    @Override
    public Speciality create(Speciality request) {
        Set<ConstraintViolation<Speciality>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return specialityRepository.save(request);
    }

    @Override
    public Speciality update(Long specialityId, Speciality request) {
        Set<ConstraintViolation<Speciality>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return specialityRepository.findById(specialityId).map(client ->
                specialityRepository.save(
                        client.withName(request.getName())
                                .withInstitutionName(request.getInstitutionName()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, specialityId));
    }

    @Override
    public ResponseEntity<?> delete(Long specialityId) {
        return specialityRepository.findById(specialityId).map(client -> {
            specialityRepository.delete(client);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, specialityId));
    }
}
