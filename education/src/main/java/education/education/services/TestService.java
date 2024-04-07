package education.education.services;

import education.education.models.Test;
import education.education.repositories.TestRepository;
import education.education.services.interfaces.DataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements DataProvider<Test> {
    @Autowired
    private TestRepository testRepository;

    @Override
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public Test findById(int id) {
        Test test = testRepository.findById(id).orElseThrow(() -> new RuntimeException("Test could not be found id=" + id));
        return test;
    }
}
