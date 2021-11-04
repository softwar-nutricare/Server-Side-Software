package pe.edu.upc.NutriCare_API.client.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResource {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
