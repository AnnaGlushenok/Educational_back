package education.education.services.interfaces;

import education.education.dtos.TestDTO;

/**
 * This interface extends the DataProvider interface for retrieving TestDTO objects.
 */
public interface TestProvider extends DataProvider<TestDTO> {
    /**
     * Retrieves a TestDTO object by its ID.
     *
     * @param id The ID of the test to retrieve.
     * @return The TestDTO object corresponding to the specified ID.
     */
    TestDTO findById(int id);
}
