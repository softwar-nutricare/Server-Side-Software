package pe.edu.upc.NutriCare_API.bill.resource;

import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
@Getter
@Setter
public class BillResource {

    private Long id;
    private Client client;
    private Double amount;
    private Integer ruc;
}
