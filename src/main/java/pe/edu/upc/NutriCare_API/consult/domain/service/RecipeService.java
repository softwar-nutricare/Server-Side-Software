package pe.edu.upc.NutriCare_API.consult.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.NutriCare_API.consult.domain.model.entity.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAll();
    Page<Recipe> getAll(Pageable pageable);
    Recipe getById(Long recipeId);
    Recipe create(Recipe recipe);
    Recipe update(Long recipeId, Recipe request);
    ResponseEntity<?> delete(Long recipeId);
}
