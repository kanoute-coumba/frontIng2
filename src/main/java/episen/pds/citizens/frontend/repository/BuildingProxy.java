package episen.pds.citizens.frontend.repository;

import episen.pds.citizens.frontend.CustomProperties;
import episen.pds.citizens.frontend.model.BuildingPatch;
import episen.pds.citizens.frontend.model.architectureModel.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class BuildingProxy {

    @Autowired
    private static CustomProperties props = new CustomProperties();

    public Iterable<BuildingPatch> getBuildings() {
        String url = props.getApiUrl() + "/buildingsPatch";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<BuildingPatch>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        return response.getBody();
    }
    public ArrayList<Building> getBuildingByIdUser(int id_user) {
        String url = props.getApiUrl() + "/BuildingByUser/"+id_user;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArrayList<Building>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        return response.getBody();
    }
}
