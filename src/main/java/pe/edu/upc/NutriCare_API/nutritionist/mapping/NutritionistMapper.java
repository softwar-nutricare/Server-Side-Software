package pe.edu.upc.NutriCare_API.nutritionist.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.NutriCare_API.nutritionist.domain.model.entity.Nutritionist;
import pe.edu.upc.NutriCare_API.nutritionist.resource.CreateNutritionistResource;
import pe.edu.upc.NutriCare_API.nutritionist.resource.NutritionistResource;
import pe.edu.upc.NutriCare_API.nutritionist.resource.UpdateNutritionistResource;
import pe.edu.upc.NutriCare_API.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class NutritionistMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public NutritionistResource toResource(Nutritionist model) { return mapper.map(model, NutritionistResource.class); }

    public Page<NutritionistResource> modelListToPage(List<Nutritionist> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, NutritionistResource.class), pageable, modelList.size());
    }

    public Nutritionist toModel(CreateNutritionistResource resource) { return mapper.map(resource, Nutritionist.class); }

    public Nutritionist toModel(UpdateNutritionistResource resource) { return mapper.map(resource, Nutritionist.class); }
}
