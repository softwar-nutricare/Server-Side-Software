package pe.edu.upc.NutriCare_API.client.resource;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateClientResource {

    @NotNull
    @Size(max = 16)
    private String username;

    @NotNull
    @Size(max = 60)
    private String password;

    @NotNull
    @Size(max = 50)
    private String firstName;

    @NotNull
    @Size(max = 50)
    private String lastName;

    @NotNull
    @Size(max = 50)
    private String email;
}
