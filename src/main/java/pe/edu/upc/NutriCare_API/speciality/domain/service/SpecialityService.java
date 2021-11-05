package pe.edu.upc.NutriCare_API.speciality.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.NutriCare_API.speciality.domain.model.entity.Speciality;

import java.util.List;

public interface SpecialityService {
    List<Speciality> getAll();
    Page<Speciality> getAll(Pageable pageable);
    Speciality getById(Long specialityId);
    Speciality create(Speciality speciality);
    Speciality update(Long specialityId, Speciality request);
    ResponseEntity<?> delete(Long specialityId);
}
