package pe.edu.upc.NutriCare_API.bill.service;
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
import pe.edu.upc.NutriCare_API.bill.domain.model.entity.Bill;
import pe.edu.upc.NutriCare_API.bill.domain.persistence.BillRepository;
import pe.edu.upc.NutriCare_API.bill.domain.service.BillService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class BillServiceImpl implements BillService {

    private static final String ENTITY = "Bill";

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private Validator validator;

    public List<Bill> getAll() { return billRepository.findAll(); }

    @Override
    public Page<Bill> getAll(Pageable pageable) {
        return billRepository.findAll(pageable);
    }

    @Override
    public Bill getById(Long billId) {
        return billRepository.findById(billId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, billId));
    }

    @Override
    public Bill create(Bill request) {
        Set<ConstraintViolation<Bill>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return billRepository.save(request);
    }

    @Override
    public Bill update(Long billId, Bill request) {
        Set<ConstraintViolation<Bill>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return billRepository.findById(billId).map(bill ->
                billRepository.save(
                        bill.withAmount(request.getAmount())
                                .withRuc(request.getRuc())
                        .withClient(request.getClient()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, billId));
    }

    @Override
    public ResponseEntity<?> delete(Long billId) {
        return billRepository.findById(billId).map(bill -> {
            billRepository.delete(bill);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, billId));
    }
}
