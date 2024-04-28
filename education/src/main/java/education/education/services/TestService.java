package education.education.services;

import education.education.dtos.TestDTO;
import education.education.mappers.TestMapper;
import education.education.models.Test;
import education.education.repositories.TestRepository;
import education.education.services.interfaces.Mapper;
import education.education.services.interfaces.TestProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class implementing the TestProvider interface and Mapper for TestDTO and Test entities.
 */
@Service
public class TestService implements TestProvider, Mapper<TestDTO, Test> {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TestMapper testMapper;

    /**
     * Retrieves a TestDTO object by its ID.
     *
     * @param id The ID of the test to retrieve.
     * @return The TestDTO object corresponding to the specified ID.
     * @throws RuntimeException if the test with the given ID is not found.
     */
    @Override
    public TestDTO findById(int id) {
        return toDTO(testRepository.findById(id).orElseThrow(() -> new RuntimeException("Test could not be found id=" + id)));
    }

    /**
     * Converts a Test entity to a TestDTO using the TestMapper.
     *
     * @param test The Test entity to convert.
     * @return The corresponding TestDTO.
     */
    @Override
    public TestDTO toDTO(Test test) {
        return testMapper.toDTO(test);
    }

    /**
     * Converts a list of Test entities to a list of TestDTOs using the TestMapper.
     *
     * @param list The list of Test entities to convert.
     * @return The list of corresponding TestDTOs.
     */
    @Override
    public List<TestDTO> listToDTO(List<Test> list) {
        return testMapper.listToDTO(list);
    }
}
