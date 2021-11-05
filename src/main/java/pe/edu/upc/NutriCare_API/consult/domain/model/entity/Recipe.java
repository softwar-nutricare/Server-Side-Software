package pe.edu.upc.NutriCare_API.consult.domain.model.entity;

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
@Table(name = "recipes")
public class Recipe extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 200)
    @Column(unique = true)
    private String recipeTitle;

    @NotNull
    @NotBlank
    @Size(max = 500)
    private String ingredients;

    @NotNull
    @NotBlank
    @Size(max = 700)
    private String preparation;

    @NotNull
    @NotBlank
    @Size(max = 150)
    private String calories;



}
