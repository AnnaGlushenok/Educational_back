package education.education.services;

import education.education.dtos.TestDTO;
import education.education.mappers.TestMapper;
import education.education.models.Test;
import education.education.repositories.TestRepository;
import education.education.services.interfaces.DataProvider;
import education.education.services.interfaces.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements DataProvider<Test>, Mapper<TestDTO, Test> {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public Test findById(int id) {
        Test test = testRepository.findById(id).orElseThrow(() -> new RuntimeException("Test could not be found id=" + id));
        return test;
    }

    @Override
    public TestDTO toDTO(Test test) {
        return testMapper.toDTO(test);
    }
}
