package pe.edu.upc.NutriCare_API.appointment.domain.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import pe.edu.upc.NutriCare_API.appointment.domain.model.entity.Appointment;
import java.util.List;
public interface AppointmentService {
    List<Appointment> getAll();
    Page<Appointment> getAll(Pageable pageable);
    Appointment getById(Long appointmentId);
    Appointment create(Appointment appointment);
    Appointment update(Long appointmentId, Appointment request);
    ResponseEntity<?> delete(Long appointmentId);
}
