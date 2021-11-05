package pe.edu.upc.NutriCare_API.diet.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NutriCare_API.diet.domain.service.DietService;
import pe.edu.upc.NutriCare_API.diet.mapping.DietMapper;
import pe.edu.upc.NutriCare_API.diet.resource.CreateDietResource;
import pe.edu.upc.NutriCare_API.diet.resource.DietResource;
import pe.edu.upc.NutriCare_API.diet.resource.UpdateDietResource;

@RestController
@RequestMapping("api/v1/diets")
public class DietController {

    @Autowired
    private DietService dietService;

    @Autowired
    private DietMapper mapper;

    @GetMapping
    public Page<DietResource> getAllDiets(Pageable pageable) {
        return mapper.modelListToPage(dietService.getAll(), pageable);
    }

    @GetMapping("{dietId}")
    public DietResource getDietById(@PathVariable("dietId") Long dietId) {
        return mapper.toResource(dietService.getById(dietId));
    }

    @PostMapping
    public DietResource createDiet(@RequestBody CreateDietResource request) {
        return mapper.toResource(dietService.create(mapper.toModel(request)));
    }

    @PutMapping("{dietId}")
    public DietResource updateDiet(@PathVariable Long dietId, @RequestBody UpdateDietResource request) {
        return mapper.toResource(dietService.update(dietId, mapper.toModel(request)));
    }

    @DeleteMapping("{dietId}")
    public ResponseEntity<?> deleteDiet(@PathVariable Long dietId) {
        return dietService.delete(dietId);
    }

}
