package episen.pds.citizens.frontcitizens;

import episen.pds.citizens.frontcitizens.repository.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lombok.Data;

import java.util.logging.Logger;

@Data
@SpringBootApplication
public class FrontcitizensApplication implements FrontcitizensApplicationOverride {

	@Autowired
	private CustomProperties properties;
	private static final Logger logger = Logger.getLogger(FrontcitizensApplication.class.getName());


	public static void main(String[] args) {
		SpringApplication.run(FrontcitizensApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.config(properties.getApiUrl());
	}

}
