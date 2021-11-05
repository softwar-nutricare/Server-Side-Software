package pe.edu.upc.NutriCare_API.speciality.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.NutriCare_API.speciality.domain.model.entity.Speciality;
import pe.edu.upc.NutriCare_API.speciality.resource.CreateSpecialityResource;
import pe.edu.upc.NutriCare_API.speciality.resource.SpecialityResource;
import pe.edu.upc.NutriCare_API.speciality.resource.UpdateSpecialityResource;
import pe.edu.upc.NutriCare_API.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class SpecialityMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public SpecialityResource toResource(Speciality model) { return mapper.map(model, SpecialityResource.class); }

    public Page<SpecialityResource> modelListToPage(List<Speciality> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, SpecialityResource.class), pageable, modelList.size());
    }

    public Speciality toModel(CreateSpecialityResource resource) { return mapper.map(resource, Speciality.class); }

    public Speciality toModel(UpdateSpecialityResource resource) { return mapper.map(resource,Speciality.class); }
}
