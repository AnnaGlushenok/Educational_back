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
public class TestService implements DataProvider<TestDTO>, Mapper<TestDTO, Test> {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TestMapper testMapper;

    @Override
    public List<TestDTO> findAll() {
        return testMapper.listToDTO(testRepository.findAll());
    }

    @Override
    public TestDTO findById(int id) {
        TestDTO test = toDTO(testRepository.findById(id).orElseThrow(() -> new RuntimeException("Test could not be found id=" + id)));
        return test;
    }

    @Override
    public TestDTO toDTO(Test test) {
        return testMapper.toDTO(test);
    }

    @Override
    public List<TestDTO> listToDTO(List<Test> list) {
        return testMapper.listToDTO(list);
    }
}
