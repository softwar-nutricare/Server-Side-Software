package pe.edu.upc.NutriCare_API.nutritionist.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NutriCare_API.nutritionist.domain.service.NutritionistService;
import pe.edu.upc.NutriCare_API.nutritionist.mapping.NutritionistMapper;
import pe.edu.upc.NutriCare_API.nutritionist.resource.CreateNutritionistResource;
import pe.edu.upc.NutriCare_API.nutritionist.resource.NutritionistResource;
import pe.edu.upc.NutriCare_API.nutritionist.resource.UpdateNutritionistResource;

@RestController
@RequestMapping("api/v1/nutritionists")
public class NutritionistController {
    @Autowired
    private NutritionistService nutritionistService;

    @Autowired
    private NutritionistMapper mapper;

    @GetMapping
    public Page<NutritionistResource> getAllClients(Pageable pageable) {
        return mapper.modelListToPage(nutritionistService.getAll(), pageable);
    }

    @GetMapping("{nutritionistId}")
    public NutritionistResource getClientById(@PathVariable("nutritionistId") Long clientId) {
        return mapper.toResource(nutritionistService.getById(clientId));
    }

    @PostMapping
    public NutritionistResource createClient(@RequestBody CreateNutritionistResource request) {
        return mapper.toResource(nutritionistService.create(mapper.toModel(request)));
    }

    @PutMapping("{nutritionistId}")
    public NutritionistResource updateClient(@PathVariable Long nutritionistId, @RequestBody UpdateNutritionistResource request) {
        return mapper.toResource(nutritionistService.update(nutritionistId, mapper.toModel(request)));
    }

    @DeleteMapping("{nutritionistId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long nutritionistId) {
        return nutritionistService.delete(nutritionistId);
    }
}
