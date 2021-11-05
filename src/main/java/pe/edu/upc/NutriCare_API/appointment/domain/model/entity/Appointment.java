package pe.edu.upc.NutriCare_API.appointment.domain.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import pe.edu.upc.NutriCare_API.shared.domain.AuditModel;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
import pe.edu.upc.NutriCare_API.diet.domain.model.entity.Diet;
import pe.edu.upc.NutriCare_API.nutritionist.domain.model.entity.Nutritionist;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="client_id", nullable = false)
    //@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @NotNull
    @NotBlank
    @Column(name = "client", nullable = true)
    private String client;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name="nutritionist_id", nullable = false)
    //@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @NotNull
    @NotBlank
    @Column(name = "nutritionist", nullable = true)
    private String nutritionist;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="diet_id", nullable = false)
    //@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @NotNull
    @NotBlank
    @Column(name = "diet", nullable = true)
    private String diet;


    @NotNull
    @NotBlank
    @Column(name = "nutritionist_notes", nullable = true)
    private String nutritionistNotes;

}
