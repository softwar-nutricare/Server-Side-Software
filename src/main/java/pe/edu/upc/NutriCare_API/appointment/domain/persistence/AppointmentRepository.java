package pe.edu.upc.NutriCare_API.appointment.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NutriCare_API.appointment.domain.model.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
}
