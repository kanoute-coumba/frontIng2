package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.ChoiceAlgoForm;
import episen.pds.citizens.frontend.model.HistoricalProductionDate;
import episen.pds.citizens.frontend.model.MixEn;
import episen.pds.citizens.frontend.model.MixEnBySite;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

@Slf4j
@Component
public class MixEnProxy {

    @Autowired
    private static CustomProperties props = new CustomProperties();
    private static final Logger logger = Logger.getLogger(MixEnProxy.class.getName());

    public static Iterable<MixEn> getCurrentMixEn() {
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/Mix";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<MixEn>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<MixEn>>() {
                }
        );

        return response.getBody();

    }

    public static Iterable<MixEnBySite> getCurrentMixEnBySite() {
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/MixBySite";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<MixEnBySite>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<MixEnBySite>>() {
                }
        );

        return response.getBody();

    }

    public static ChoiceAlgoForm getCurrentAlgoChoice(){
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/CurrentAlgoChoice";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ChoiceAlgoForm> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ChoiceAlgoForm>() {
                }
        );

        return response.getBody();
    }

    // save the new algo choice
    public ChoiceAlgoForm saveAlgoChoice(ChoiceAlgoForm e) {
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/saveAlgoChoice";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ChoiceAlgoForm> request = new HttpEntity(e);
        ResponseEntity<ChoiceAlgoForm> response = restTemplate.exchange(
                getUrl,
                HttpMethod.POST,
                request,
                ChoiceAlgoForm.class);

        return response.getBody();
    }

    public HashMap<String, List<Double>> simulationEconomicCost(HashMap<String,String> e) {
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/simulationEconomicCost";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<HashMap<String,String>> request = new HttpEntity(e);
        ResponseEntity<HashMap<String, List<Double>>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<HashMap<String, List<Double>>>() {
                }
        );
        logger.info(""+request);

        return response.getBody();
    }

    public HashMap<String, List<Double>> getGraphDataEnvironmentalCost(){
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/graphDataEnvironmentalCost";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HashMap<String, List<Double>>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<HashMap<String, List<Double>>>() {
                }
        );

        return response.getBody();

    }

    public HashMap<String, List<Double>> getHistoricalProductionByEnergy(){
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/graphDataHistoricalProductionEnergy";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HashMap<String, List<Double>>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<HashMap<String, List<Double>>>() {
                }
        );

        return response.getBody();

    }


    public List<Double> getHistoSolar(){
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/graphHSolar";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Double>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Double>>() {
                }
        );

        return response.getBody();

    }

    public List<Double> getHistoWind(){
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/graphHWind";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Double>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Double>>() {
                }
        );

        return response.getBody();

    }

    public List<Double> getHistoHydraulic(){
        String baseApiUrl = props.getApiUrl();
        String getUrl = baseApiUrl + "/graphHHydraulic";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Double>> response = restTemplate.exchange(
                getUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Double>>() {
                }
        );

        return response.getBody();

    }

}
