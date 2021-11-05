package pe.edu.upc.NutriCare_API.profesionalProfiles.domain.model.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import pe.edu.upc.NutriCare_API.nutritionist.domain.model.entity.Nutritionist;
import pe.edu.upc.NutriCare_API.shared.domain.AuditModel;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profesionals")
public class Profesional extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(unique = false)
    private String experience;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nutritionist_id", nullable = false)
    private Nutritionist nutritionist;

}
