package pe.edu.upc.NutriCare_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NutriCareApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutriCareApiApplication.class, args);
	}

}
