package episen.pds.citizens.frontend;

import lombok.Data;
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
