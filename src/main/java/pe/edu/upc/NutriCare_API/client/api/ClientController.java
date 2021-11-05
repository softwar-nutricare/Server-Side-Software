package pe.edu.upc.NutriCare_API.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NutriCare_API.client.domain.service.ClientService;
import pe.edu.upc.NutriCare_API.client.mapping.ClientMapper;
import pe.edu.upc.NutriCare_API.client.resource.ClientResource;
import pe.edu.upc.NutriCare_API.client.resource.CreateClientResource;
import pe.edu.upc.NutriCare_API.client.resource.UpdateClientResource;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper mapper;

    @GetMapping
    public Page<ClientResource> getAllClients(Pageable pageable) {
        return mapper.modelListToPage(clientService.getAll(), pageable);
    }

    @GetMapping("{clientId}")
    public ClientResource getClientById(@PathVariable("clientId") Long clientId) {
        return mapper.toResource(clientService.getById(clientId));
    }

    @PostMapping
    public ClientResource createClient(@RequestBody CreateClientResource request) {
        return mapper.toResource(clientService.create(mapper.toModel(request)));
    }

    @PutMapping("{clientId}")
    public ClientResource updateClient(@PathVariable Long clientId, @RequestBody UpdateClientResource request) {
        return mapper.toResource(clientService.update(clientId, mapper.toModel(request)));
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        return clientService.delete(clientId);
    }

}
