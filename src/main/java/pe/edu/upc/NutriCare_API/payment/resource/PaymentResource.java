package pe.edu.upc.NutriCare_API.payment.resource;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResource {
    private Long id;
    private String client;
    private String cartType;
    private String cardNumber;
    private String expirationDateMonth;
    private String expirationDateYear;
    private String securityCode;
    private String ownerFirstname;
    private String ownerLastname;
    private String city;
    private String billingAddress;
    private String billingAddressLine2;
    private String postalCode;
    private String country;
    private String phoneNumber;
}
