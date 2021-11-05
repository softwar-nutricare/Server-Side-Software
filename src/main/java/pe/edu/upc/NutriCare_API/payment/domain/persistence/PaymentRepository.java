package pe.edu.upc.NutriCare_API.payment.domain.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NutriCare_API.payment.domain.model.entity.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
}
