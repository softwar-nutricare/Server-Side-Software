package pe.edu.upc.NutriCare_API.consult.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.NutriCare_API.consult.domain.model.entity.Recipe;
import pe.edu.upc.NutriCare_API.consult.resource.CreateRecipeResource;
import pe.edu.upc.NutriCare_API.consult.resource.RecipeResource;
import pe.edu.upc.NutriCare_API.consult.resource.UpdateRecipeResource;
import pe.edu.upc.NutriCare_API.shared.mapping.EnhancedModelMapper;

import java.util.List;

public class RecipeMapper {

    @Autowired
    EnhancedModelMapper mapper;

    //Object Mapping
    public RecipeResource toResource(Recipe model) {
        return mapper.map(model, RecipeResource.class);
    }

    public Page<RecipeResource> modelListToPage(List<Recipe> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, RecipeResource.class), pageable, modelList.size());
    }

    public Recipe toModel(CreateRecipeResource resource) {
        return mapper.map(resource, Recipe.class);
    }

    public Recipe toModel(UpdateRecipeResource resource) {
        return mapper.map(resource, Recipe.class);
    }

}
