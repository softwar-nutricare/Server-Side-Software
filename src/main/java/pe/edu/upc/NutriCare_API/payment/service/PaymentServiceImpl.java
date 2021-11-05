package pe.edu.upc.NutriCare_API.payment.service;
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
import pe.edu.upc.NutriCare_API.payment.domain.model.entity.Payment;
import pe.edu.upc.NutriCare_API.payment.domain.persistence.PaymentRepository;
import pe.edu.upc.NutriCare_API.payment.domain.service.PaymentService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
@Service
public class PaymentServiceImpl implements PaymentService{
    private static final String ENTITY = "Payment";

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private Validator validator;

    public List<Payment> getAll() { return paymentRepository.findAll(); }

    @Override
    public Page<Payment> getAll(Pageable pageable) {
        return paymentRepository.findAll(pageable);
    }

    @Override
    public Payment getById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, paymentId));
    }

    @Override
    public Payment create(Payment request) {
        Set<ConstraintViolation<Payment>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return paymentRepository.save(request);
    }

    @Override
    public Payment update(Long paymentId, Payment request) {
        Set<ConstraintViolation<Payment>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return paymentRepository.findById(paymentId).map(payment ->
                paymentRepository.save(
                        payment.withCartType(request.getCartType())
                                .withCardNumber(request.getCardNumber())
                                .withExpirationDateMonth(request.getExpirationDateMonth())
                                .withExpirationDateYear(request.getExpirationDateYear())
                                .withSecurityCode(request.getSecurityCode())
                                .withOwnerFirstname(request.getOwnerFirstname())
                                .withOwnerLastname(request.getOwnerLastname())
                                .withCity(request.getCity())
                                .withBillingAddress(request.getBillingAddress())
                                .withBillingAddressLine2(request.getBillingAddressLine2())
                                .withPostalCode(request.getPostalCode())
                                .withCountry(request.getPostalCode())
                                .withCountry(request.getCountry())
                                .withPhoneNumber(request.getPhoneNumber()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, paymentId));
    }

    @Override
    public ResponseEntity<?> delete(Long paymentId) {
        return paymentRepository.findById(paymentId).map(payment -> {
            paymentRepository.delete(payment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, paymentId));
    }

}
