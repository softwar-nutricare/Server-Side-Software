package pe.edu.upc.NutriCare_API.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
import pe.edu.upc.NutriCare_API.client.domain.persistence.ClientRepository;
import pe.edu.upc.NutriCare_API.client.domain.service.ClientService;
import pe.edu.upc.NutriCare_API.shared.exception.ResourceNotFoundException;
import pe.edu.upc.NutriCare_API.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {

    private static final String ENTITY = "Client";

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private Validator validator;

    public List<Client> getAll() { return clientRepository.findAll(); }

    @Override
    public Page<Client> getAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Client getById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, clientId));
    }

    @Override
    public Client create(Client request) {
        Set<ConstraintViolation<Client>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return clientRepository.save(request);
    }

    @Override
    public Client update(Long clientId, Client request) {
        Set<ConstraintViolation<Client>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return clientRepository.findById(clientId).map(client ->
                clientRepository.save(
                        client.withUsername(request.getUsername())
                                .withPassword(request.getPassword())
                                .withFirstName(request.getFirstName())
                                .withLastName(request.getLastName())
                                .withEmail(request.getEmail()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, clientId));
    }

    @Override
    public ResponseEntity<?> delete(Long clientId) {
        return clientRepository.findById(clientId).map(client -> {
            clientRepository.delete(client);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, clientId));
    }
}
