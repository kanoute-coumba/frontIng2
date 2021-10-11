package episen.pds.citizens.frontcitizens;

import episen.pds.citizens.frontcitizens.repository.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lombok.Data;

@Data
@SpringBootApplication
public class FrontcitizensApplication implements FrontcitizensApplicationOverride {

	@Autowired
	private CustomProperties properties;

	public static void main(String[] args) {
		SpringApplication.run(FrontcitizensApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(properties.getApiUrl());
	}

}
