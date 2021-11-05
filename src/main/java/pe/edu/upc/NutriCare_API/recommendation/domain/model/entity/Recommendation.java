package pe.edu.upc.NutriCare_API.recommendation.domain.model.entity;

import lombok.*;
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
@Table(name = "recommendations")
public class Recommendation extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 10)
    @Column(unique = true)
    private String authorId;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String description;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String createdAtDate;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String lastModification;
}
