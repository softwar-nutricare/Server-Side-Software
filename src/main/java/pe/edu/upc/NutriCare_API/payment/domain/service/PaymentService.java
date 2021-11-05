package pe.edu.upc.NutriCare_API.payment.domain.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
import pe.edu.upc.NutriCare_API.payment.domain.model.entity.Payment;
import java.util.List;
public interface PaymentService {
    List<Payment> getAll();
    Page<Payment> getAll(Pageable pageable);
    Payment getById(Long paymentId);
    Payment create(Payment payment);
    Payment update(Long paymentId, Payment request);
    ResponseEntity<?> delete(Long paymentId);
}
