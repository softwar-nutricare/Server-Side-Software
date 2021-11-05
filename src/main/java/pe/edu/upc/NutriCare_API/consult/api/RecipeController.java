package pe.edu.upc.NutriCare_API.consult.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NutriCare_API.consult.domain.service.RecipeService;
import pe.edu.upc.NutriCare_API.consult.mapping.RecipeMapper;
import pe.edu.upc.NutriCare_API.consult.resource.CreateRecipeResource;
import pe.edu.upc.NutriCare_API.consult.resource.RecipeResource;
import pe.edu.upc.NutriCare_API.consult.resource.UpdateRecipeResource;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeMapper mapper;

    @GetMapping
    public Page<RecipeResource> getAllRecipes(Pageable pageable){
        return mapper.modelListToPage(recipeService.getAll(), pageable);
    }

    @GetMapping("{recipeId}")
    public RecipeResource getRecipeById(@PathVariable("recipeId") Long recipeId) {
        return mapper.toResource(recipeService.getById(recipeId));
    }

    @PostMapping
    public RecipeResource createRecipe(@RequestBody CreateRecipeResource request) {
        return mapper.toResource(recipeService.create(mapper.toModel(request)));
    }

    @PutMapping("{recipeId}")
    public RecipeResource updateRecipe(@PathVariable Long recipeId, @RequestBody UpdateRecipeResource request) {
        return mapper.toResource(recipeService.update(recipeId, mapper.toModel(request)));
    }

    @DeleteMapping("{recipeId}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long recipeId) {
        return recipeService.delete(recipeId);
    }
}
