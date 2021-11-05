package pe.edu.upc.NutriCare_API.client.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
