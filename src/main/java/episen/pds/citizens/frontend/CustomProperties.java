package episen.pds.citizens.frontend;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ConfigurationProperties(prefix = "episen.pds.citizens.frontend")

public class CustomProperties {

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiLocalUrl() {
        return apiLocalUrl;
    }

    public void setApiLocalUrl(String apiLocalUrl) {
        this.apiLocalUrl = apiLocalUrl;
    }

    public String getApiArchitectureUrl() {
        return apiArchitectureUrl;
    }

    public String getApiLocalArchitectureUrl() {
        return apiLocalArchitectureUrl;
    }

    //private String apiUrl= "http://172.31.249.1:9000";
    private String apiUrl= "http://localhost:9000";
    private String apiLocalUrl ="http://localhost:9000";
    private final String apiArchitectureUrl = "http://172.31.249.1:9000/architecture/";
    private final String apiLocalArchitectureUrl = "http://localhost:9000/architecture/";


}
