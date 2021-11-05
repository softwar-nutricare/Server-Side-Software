package pe.edu.upc.NutriCare_API.payment.resource;

import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreatePaymentResource {


    @NotNull
    private String client;
    @NotNull
    @Size(max = 60)
    private String cartType;
    @NotNull
    @Size(max = 60)
    private String cardNumber;
    @NotNull
    @Size(max = 60)
    private String expirationDateMonth;
    @NotNull
    @Size(max = 60)
    private String expirationDateYear;
    @NotNull
    @Size(max = 60)
    private String securityCode;
    @NotNull
    @Size(max = 60)
    private String ownerFirstname;
    @NotNull
    @Size(max = 60)
    private String ownerLastname;
    @NotNull
    @Size(max = 60)
    private String city;
    @NotNull
    @Size(max = 60)
    private String billingAddress;
    @NotNull
    @Size(max = 60)
    private String billingAddressLine2;
    @NotNull
    @Size(max = 60)
    private String postalCode;
    @NotNull
    @Size(max = 60)
    private String country;
    @NotNull
    @Size(max = 60)
    private String phoneNumber;
}
