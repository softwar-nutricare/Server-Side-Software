package pe.edu.upc.NutriCare_API.bill.resource;

import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
public class CreateBillResource {

    @NotNull
    private String client;

    @NotNull
    private String amount;

    @NotNull
    @Size(max = 16)
    private String ruc;
}


