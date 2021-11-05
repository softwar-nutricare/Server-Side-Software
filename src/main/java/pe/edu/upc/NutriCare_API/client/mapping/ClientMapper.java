package pe.edu.upc.NutriCare_API.client.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
import pe.edu.upc.NutriCare_API.client.resource.ClientResource;
import pe.edu.upc.NutriCare_API.client.resource.CreateClientResource;
import pe.edu.upc.NutriCare_API.client.resource.UpdateClientResource;
import pe.edu.upc.NutriCare_API.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class ClientMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ClientResource toResource(Client model) { return mapper.map(model, ClientResource.class); }

    public Page<ClientResource> modelListToPage(List<Client> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ClientResource.class), pageable, modelList.size());
    }

    public Client toModel(CreateClientResource resource) {
        return mapper.map(resource, Client.class);
    }

    public Client toModel(UpdateClientResource resource) { return mapper.map(resource, Client.class); }
}
