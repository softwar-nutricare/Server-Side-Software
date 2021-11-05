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
    public Page<ProfesionalResource> getAllClients(Pageable pageable) {
        return mapper.modelListToPage(profesionalService.getAll(), pageable);
    }

    @GetMapping("{profesionalId}")
    public ProfesionalResource getClientById(@PathVariable("profesionalId") Long clientId) {
        return mapper.toResource(profesionalService.getById(clientId));
    }

    @PostMapping
    public ProfesionalResource createClient(@RequestBody CreateProfesionalResource request) {
        return mapper.toResource(profesionalService.create(mapper.toModel(request)));
    }

    @PutMapping("{profesionalId}")
    public ProfesionalResource updateClient(@PathVariable Long profesionalId, @RequestBody UpdateProfesionalResource request) {
        return mapper.toResource(profesionalService.update(profesionalId, mapper.toModel(request)));
    }

    @DeleteMapping("{profesionalId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long profesionalId) {
        return profesionalService.delete(profesionalId);
    }
}
