package episen.pds.citizens.frontcitizens.repository;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


@Configuration
@ConfigurationProperties(prefix = "episen.pds.frontcitizens")
@Data
public class CustomProperties {

    private String apiUrl = "http://172.31.249.1:9000";

}
