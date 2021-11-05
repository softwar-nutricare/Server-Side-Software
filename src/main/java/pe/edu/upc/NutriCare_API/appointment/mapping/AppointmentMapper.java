package pe.edu.upc.NutriCare_API.appointment.mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
import pe.edu.upc.NutriCare_API.client.resource.ClientResource;
import pe.edu.upc.NutriCare_API.client.resource.CreateClientResource;
import pe.edu.upc.NutriCare_API.client.resource.UpdateClientResource;
import pe.edu.upc.NutriCare_API.appointment.domain.model.entity.Appointment;
import pe.edu.upc.NutriCare_API.appointment.resource.AppointmentResource;
import pe.edu.upc.NutriCare_API.appointment.resource.CreateAppointmentResource;
import pe.edu.upc.NutriCare_API.appointment.resource.UpdateAppointmentResource;
import pe.edu.upc.NutriCare_API.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class AppointmentMapper implements Serializable{

    @Autowired
    EnhancedModelMapper mapper;
    public AppointmentResource toResource(Appointment model) { return mapper.map(model, AppointmentResource.class); }

    public Page<AppointmentResource> modelListToPage(List<Appointment> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, AppointmentResource.class), pageable, modelList.size());
    }

    public Appointment toModel(CreateAppointmentResource resource) {
        return mapper.map(resource, Appointment.class);
    }

    public Appointment toModel(UpdateAppointmentResource resource) { return mapper.map(resource, Appointment.class); }
}
