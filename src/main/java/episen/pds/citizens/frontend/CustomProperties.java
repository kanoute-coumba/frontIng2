package episen.pds.citizens.frontend;


import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ConfigurationProperties(prefix = "episen.pds.citizens.frontend")

public class CustomProperties {

    private String apiUrl;




}
