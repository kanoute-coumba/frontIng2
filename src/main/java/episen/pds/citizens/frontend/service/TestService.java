package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.repository.TestProxy;
import lombok.Data;

import episen.pds.citizens.frontend.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class TestService {

    @Autowired
    private TestProxy testProxy = new TestProxy();

    public Test getTest(final int id) {
        return (Test) testProxy.getTest();
    }
    public Iterable<Test> getTest() {
        return TestProxy.getTest();

    }
    public void deleteTest(final int id) {
        testProxy.deleteTest(id);;
    }
    public Test saveTest(Test test) {
        System.out.println("fffffffffffff");
        System.out.println(test);

        Test savedTest;

        // Règle de gestion : Le nom de famille doit être mis en majuscule.
        test.setFirstname(test.getFirstname().toUpperCase());
        savedTest = testProxy.createTest(test);
       // System.out.println(savedTest + "hh");

//        if(test.getId() == null) {
//            // Si l'id est nul, alors c'est un nouvel employé.
//            savedTest = testProxy.createTest(test);
//        }
//        else {
//            savedTest = testProxy.updateTest(test);
//        }

        return savedTest;
    }
}











