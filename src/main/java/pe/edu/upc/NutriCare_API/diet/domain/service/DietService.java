package pe.edu.upc.NutriCare_API.diet.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.NutriCare_API.diet.domain.model.entity.Diet;

import java.util.List;

public interface DietService {
    List<Diet> getAll();
    Page<Diet> getAll(Pageable pageable);
    Diet getById(Long dietId);
    Diet create(Diet diet);
    Diet update(Long dietId, Diet request);
    ResponseEntity<?> delete(Long dietId);

}
