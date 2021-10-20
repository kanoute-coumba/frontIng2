package episen.pds.citizens.frontend.service;

import episen.pds.citizens.frontend.repository.TestProxy;
import lombok.Data;

import episen.pds.citizens.frontend.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Iterator;
import java.util.logging.Logger;

@Data
@Service
public class TestService {

    @Autowired
    private TestProxy testProxy = new TestProxy();
    private static final Logger logger = Logger.getLogger(TestService.class.getName());

    public Test getTest(final int id) {
        return (Test) testProxy.getTest();
    }

    public Iterable<Test> getTest() {
        return TestProxy.getTest();

    }

    public void deleteTest(@PathVariable int id) {
        logger.info("début delete");
        testProxy.deleteTestId(id);
        logger.info("delete done");

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











