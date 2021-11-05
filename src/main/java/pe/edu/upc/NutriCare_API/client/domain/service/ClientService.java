package pe.edu.upc.NutriCare_API.client.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
import java.util.List;

public interface ClientService {
    List<Client> getAll();
    Page<Client> getAll(Pageable pageable);
    Client getById(Long clientId);
    Client create(Client client);
    Client update(Long clientId, Client request);
    ResponseEntity<?> delete(Long clientId);
}
