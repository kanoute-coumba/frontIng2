package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.model.District;
import episen.pds.citizens.frontend.repository.DistrictProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    private DistrictProxy districtProxy;

    public List<District> readDistricts() {
        return districtProxy.readDistricts();
    }
}
