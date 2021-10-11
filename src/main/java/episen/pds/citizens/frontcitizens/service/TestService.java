package episen.pds.citizens.frontcitizens.service;

import episen.pds.citizens.frontcitizens.model.Test;
import episen.pds.citizens.frontcitizens.repository.TestProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import episen.pds.citizens.frontcitizens.repository.TestProxy;


import lombok.Data;

@Data
@Service
public class TestService {

    @Autowired
    private TestProxy testProxy;


    public Iterable<Test> getTests() {
        return testProxy.getTests();
    }

    public Test getTest() {
        return testProxy.getTest();
    }

    public Test saveTest(Test Test) {
        Test savedTest = (episen.pds.citizens.frontcitizens.model.Test) testProxy.getTests();

        return savedTest;
    }

}
