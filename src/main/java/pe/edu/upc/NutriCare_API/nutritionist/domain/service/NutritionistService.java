package pe.edu.upc.NutriCare_API.nutritionist.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.NutriCare_API.nutritionist.domain.model.entity.Nutritionist;

import java.util.List;

public interface NutritionistService {
    List<Nutritionist> getAll();
    Page<Nutritionist> getAll(Pageable pageable);
    Nutritionist getById(Long nutritionistId);
    Nutritionist create(Nutritionist nutritionist);
    Nutritionist update(Long nutritionistId, Nutritionist request);
    ResponseEntity<?> delete(Long nutritionistId);
}
