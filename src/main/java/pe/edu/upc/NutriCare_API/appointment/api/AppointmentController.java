package pe.edu.upc.NutriCare_API.appointment.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.NutriCare_API.appointment.domain.service.AppointmentService;
import pe.edu.upc.NutriCare_API.appointment.mapping.AppointmentMapper;
import pe.edu.upc.NutriCare_API.appointment.resource.AppointmentResource;
import pe.edu.upc.NutriCare_API.appointment.resource.CreateAppointmentResource;
import pe.edu.upc.NutriCare_API.appointment.resource.UpdateAppointmentResource;

@RestController
@RequestMapping("api/v1/appointments")
public class AppointmentController {



    @Autowired
    private AppointmentService appointmentService;


    @Autowired
    private AppointmentMapper mapper;

    @GetMapping
    public Page<AppointmentResource> getAllAppointments(Pageable pageable) {
        return mapper.modelListToPage(appointmentService.getAll(), pageable);
    }

    @GetMapping("{appointmentId}")
    public AppointmentResource getAppointmentById(@PathVariable("appointmentId") Long appointmentId) {
        return mapper.toResource(appointmentService.getById(appointmentId));
    }


    @PostMapping
    public AppointmentResource createAppointment(@RequestBody CreateAppointmentResource request) {
        return mapper.toResource(appointmentService.create(mapper.toModel(request)));
    }

    @PutMapping("{appointmentId}")
    public AppointmentResource updateAppointment(@PathVariable Long appointmentId, @RequestBody UpdateAppointmentResource request) {
        return mapper.toResource(appointmentService.update(appointmentId, mapper.toModel(request)));
    }

    @DeleteMapping("{appointmentId}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long appointmentId) {
        return appointmentService.delete(appointmentId);
    }

}
