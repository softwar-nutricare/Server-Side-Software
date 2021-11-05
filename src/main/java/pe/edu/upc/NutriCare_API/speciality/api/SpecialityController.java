package pe.edu.upc.NutriCare_API.speciality.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NutriCare_API.speciality.domain.service.SpecialityService;
import pe.edu.upc.NutriCare_API.speciality.mapping.SpecialityMapper;
import pe.edu.upc.NutriCare_API.speciality.resource.CreateSpecialityResource;
import pe.edu.upc.NutriCare_API.speciality.resource.SpecialityResource;
import pe.edu.upc.NutriCare_API.speciality.resource.UpdateSpecialityResource;

@RestController
@RequestMapping("api/v1/specialities")
public class SpecialityController {
    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private SpecialityMapper mapper;

    @GetMapping
    public Page<SpecialityResource> getAllSpecialities(Pageable pageable) {
        return mapper.modelListToPage(specialityService.getAll(), pageable);
    }

    @GetMapping("{specialityId}")
    public SpecialityResource getSpecialityById(@PathVariable("specialityId") Long clientId) {
        return mapper.toResource(specialityService.getById(clientId));
    }

    @PostMapping
    public SpecialityResource createSpeciality(@RequestBody CreateSpecialityResource request) {
        return mapper.toResource(specialityService.create(mapper.toModel(request)));
    }

    @PutMapping("{specialityId}")
    public SpecialityResource updateSpeciality(@PathVariable Long specialityId, @RequestBody UpdateSpecialityResource request) {
        return mapper.toResource(specialityService.update(specialityId, mapper.toModel(request)));
    }

    @DeleteMapping("{specialityId}")
    public ResponseEntity<?> deleteSpeciality(@PathVariable Long specialityId) {
        return specialityService.delete(specialityId);
    }
}
