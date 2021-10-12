package episen.pds.citizens.frontend;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Data
@SpringBootApplication
public class FrontEndApplication  {



	public static void main(String[] args) {
		SpringApplication.run(FrontEndApplication.class, args);
	}


	public void run(String... args) throws Exception {

	}
}
