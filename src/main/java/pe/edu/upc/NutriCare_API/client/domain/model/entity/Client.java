package pe.edu.upc.NutriCare_API.client.domain.model.entity;


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
@Table(name = "clients")
public class Client extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 16)
    @Column(unique = true)
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String password;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String email;
}
