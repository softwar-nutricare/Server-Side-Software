package pe.edu.upc.NutriCare_API.profesionalProfiles.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.NutriCare_API.profesionalProfiles.domain.model.entity.Profesional;
import pe.edu.upc.NutriCare_API.profesionalProfiles.resource.CreateProfesionalResource;
import pe.edu.upc.NutriCare_API.profesionalProfiles.resource.ProfesionalResource;
import pe.edu.upc.NutriCare_API.profesionalProfiles.resource.UpdateProfesionalResource;
import pe.edu.upc.NutriCare_API.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class ProfesionalMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ProfesionalResource toResource(Profesional model) { return mapper.map(model, ProfesionalResource.class); }

    public Page<ProfesionalResource> modelListToPage(List<Profesional> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ProfesionalResource.class), pageable, modelList.size());
    }

    public Profesional toModel(CreateProfesionalResource resource) { return mapper.map(resource, Profesional.class); }

    public Profesional toModel(UpdateProfesionalResource resource) { return mapper.map(resource, Profesional.class); }
}
