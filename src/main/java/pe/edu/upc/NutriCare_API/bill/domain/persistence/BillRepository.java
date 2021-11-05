package pe.edu.upc.NutriCare_API.bill.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
import pe.edu.upc.NutriCare_API.bill.domain.model.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{
}
