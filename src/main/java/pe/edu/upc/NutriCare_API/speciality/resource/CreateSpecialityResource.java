package pe.edu.upc.NutriCare_API.speciality.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateSpecialityResource {

    @NotNull

    @Size(max = 30)

    private String name;

    @NotNull
    @Size(max = 30)
    private String institutionName;
}
