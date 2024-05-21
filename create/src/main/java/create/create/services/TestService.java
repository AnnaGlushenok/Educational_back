package create.create.services;

import create.create.dtos.TestDTO;
import create.create.mappers.TestMapper;
import create.create.repositories.TestRepository;
import create.create.services.interfaces.TestProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class implementing the TestProvider interface.
 */
@Service
public class TestService implements TestProvider {
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
        return testMapper.toDTO(testRepository.findById(id).orElseThrow(() -> new RuntimeException("Test could not be found id=" + id)));
    }
}
