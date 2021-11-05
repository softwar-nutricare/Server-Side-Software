package pe.edu.upc.NutriCare_API.payment.domain.model.entity;

import lombok.*;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
import pe.edu.upc.NutriCare_API.shared.domain.AuditModel;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id", nullable = false)
    //@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Client client;

    @NotNull
    @NotBlank
    @Column(name="cartType", nullable = false)
    private String cartType;
    @NotNull
    @NotBlank
    @Column(name="cardNumber", nullable = false)
    private String cardNumber;
    @NotNull
    @NotBlank
    @Column(name="expirationDateMonth", nullable = false)
    private String expirationDateMonth;
    @NotNull
    @NotBlank
    @Column(name="expirationDateYear", nullable = false)
    private String expirationDateYear;
    @NotNull
    @NotBlank
    @Column(name="securityCode", nullable = false)
    private String securityCode;
    @NotNull
    @NotBlank
    @Column(name="ownerFirstname", nullable = false)
    private String ownerFirstname;
    @NotNull
    @NotBlank
    @Column(name="ownerLastname", nullable = false)
    private String ownerLastname;
    @NotNull
    @NotBlank
    @Column(name="city", nullable = false)
    private String city;
    @NotNull
    @NotBlank
    @Column(name="billingAddress", nullable = false)
    private String billingAddress;
    @NotNull
    @NotBlank
    @Column(name="billingAddressLine2", nullable = false)
    private String billingAddressLine2;
    @NotNull
    @NotBlank
    @Column(name="postalCode", nullable = false)
    private String postalCode;
    @NotNull
    @NotBlank
    @Column(name="country", nullable = false)
    private String country;
    @NotNull
    @NotBlank
    @Column(name="honeNumber", nullable = false)
    private String phoneNumber;






}
