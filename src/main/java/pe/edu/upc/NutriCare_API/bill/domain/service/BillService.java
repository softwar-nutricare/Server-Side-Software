package pe.edu.upc.NutriCare_API.bill.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
import pe.edu.upc.NutriCare_API.bill.domain.model.entity.Bill;
import java.util.List;

public interface BillService {

    List<Bill> getAll();
    Page<Bill> getAll(Pageable pageable);
    Bill getById(Long billId);
    Bill create(Bill bill);
    Bill update(Long billId, Bill request);
    ResponseEntity<?> delete(Long billId);

}
