package com.miashs.emploi_du_temps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EmploiDuTempsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmploiDuTempsApplication.class, args);
	}

}
