package pe.edu.upc.NutriCare_API.consult.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.NutriCare_API.consult.domain.model.entity.Recipe;
import pe.edu.upc.NutriCare_API.consult.domain.persistence.RecipeRepository;
import pe.edu.upc.NutriCare_API.consult.domain.service.RecipeService;
import pe.edu.upc.NutriCare_API.shared.exception.ResourceNotFoundException;
import pe.edu.upc.NutriCare_API.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private static final String ENTITY = "Recipe";

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private Validator validator;

    public List<Recipe> getAll(){ return recipeRepository.findAll(); }

    @Override
    public Page<Recipe> getAll(Pageable pageable){
        return recipeRepository.findAll(pageable);
    }

    @Override
    public Recipe getById(Long recipeId) {
        return recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, recipeId));
    }

    @Override
    public Recipe create(Recipe request) {
        Set<ConstraintViolation<Recipe>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return recipeRepository.save(request);
    }

    @Override
    public Recipe update(Long recipeId, Recipe request) {
        Set<ConstraintViolation<Recipe>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return recipeRepository.findById(recipeId).map(recipe ->
                recipeRepository.save(
                        recipe.withRecipeTitle(request.getRecipeTitle())
                                .withIngredients(request.getIngredients())
                                .withPreparation(request.getPreparation())
                                .withCalories(request.getCalories()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, recipeId));
    }

    @Override
    public ResponseEntity<?> delete(Long recipeId) {
        return recipeRepository.findById(recipeId).map(post -> {
            recipeRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, recipeId));
    }
}
