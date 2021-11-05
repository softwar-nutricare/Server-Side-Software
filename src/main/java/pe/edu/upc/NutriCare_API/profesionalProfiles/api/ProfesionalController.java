package pe.edu.upc.NutriCare_API.profesionalProfiles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NutriCare_API.profesionalProfiles.domain.service.ProfesionalService;
import pe.edu.upc.NutriCare_API.profesionalProfiles.mapping.ProfesionalMapper;
import pe.edu.upc.NutriCare_API.profesionalProfiles.resource.CreateProfesionalResource;
import pe.edu.upc.NutriCare_API.profesionalProfiles.resource.ProfesionalResource;
import pe.edu.upc.NutriCare_API.profesionalProfiles.resource.UpdateProfesionalResource;

@RestController
@RequestMapping("api/v1/profesionals")
public class ProfesionalController {
    @Autowired
    private ProfesionalService profesionalService;

    @Autowired
    private ProfesionalMapper mapper;

    @GetMapping
    public Page<ProfesionalResource> getProfessionals(Pageable pageable) {
        return mapper.modelListToPage(profesionalService.getAll(), pageable);
    }

    @GetMapping("{professionalId}")
    public ProfesionalResource getProfessionalById(@PathVariable("professionalId") Long clientId) {
        return mapper.toResource(profesionalService.getById(clientId));
    }

    @PostMapping
    public ProfesionalResource createProfessional(@RequestBody CreateProfesionalResource request) {
        return mapper.toResource(profesionalService.create(mapper.toModel(request)));
    }

    @PutMapping("{professionalId}")
    public ProfesionalResource updateProfessional(@PathVariable Long professionalId, @RequestBody UpdateProfesionalResource request) {
        return mapper.toResource(profesionalService.update(professionalId, mapper.toModel(request)));
    }

    @DeleteMapping("{professionalId}")
    public ResponseEntity<?> deleteProfessional(@PathVariable Long professionalId) {
        return profesionalService.delete(professionalId);
    }
}
