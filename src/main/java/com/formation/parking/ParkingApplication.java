package com.formation.parking;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
//@SpringBootApplication=@Configuration+@EnableAutoConfiguration+@ComponentScan
//@EnableAutoConfiguration demarrer une configuration automatique au démarrage de l'api pour toutes les dépendances présentes
//@ComponentScan scanner tous les packages importés dans cette classe et leurs sous packages pour trouver les composant à instancier et à injecter 
//@Configuration dans la classe ParkingApplication on peut creer des beans de configuration à l'aide de l'annotaion bean
@Configuration
public class ParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	};

}
