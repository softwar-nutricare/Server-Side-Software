package pe.edu.upc.NutriCare_API.diet.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.NutriCare_API.diet.domain.model.entity.Diet;
import pe.edu.upc.NutriCare_API.diet.resource.CreateDietResource;
import pe.edu.upc.NutriCare_API.diet.resource.DietResource;
import pe.edu.upc.NutriCare_API.diet.resource.UpdateDietResource;
import pe.edu.upc.NutriCare_API.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class DietMapper implements Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public DietResource toResource(Diet model) { return mapper.map(model, DietResource.class); }

    public Page<DietResource> modelListToPage(List<Diet> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, DietResource.class), pageable, modelList.size());
    }

    public Diet toModel(CreateDietResource resource) {
        return mapper.map(resource, Diet.class);
    }

    public Diet toModel(UpdateDietResource resource) { return mapper.map(resource, Diet.class); }
}
