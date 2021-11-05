package pe.edu.upc.NutriCare_API.profesionalProfiles.resource;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateProfesionalResource {
    private Long id;
    @NotNull
    @Size(max = 100)
    private String experience;
}
