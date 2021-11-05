package pe.edu.upc.NutriCare_API.bill.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import pe.edu.upc.NutriCare_API.shared.domain.AuditModel;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bills")
public class Bill extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name="client_id", nullable = false)
    //@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @NotNull
    @NotBlank
    @Column(name="client", nullable = false)
    private String client;



    @NotNull
    @NotBlank
    @Column(name="amount", nullable = false)
    private String amount;

    @NotNull
    @NotBlank
    @Column(name="ruc", nullable = true)
    private String ruc;





}
