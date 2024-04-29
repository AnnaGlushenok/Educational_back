package create.create.services.interfaces;

import create.create.dtos.ControlWorkDTO;

import java.util.List;

/**
 * This interface extends the DataProvider interface for managing ControlWorkDTO objects.
 * It serves as a provider interface specifically for ControlWorkDTO data.
 */
public interface ControlWorkProvider extends DataProvider<ControlWorkDTO> {
    /**
     * Retrieves all ControlWorkDTO objects.
     *
     * @return A list of ControlWorkDTO objects representing all available control works.
     */
    List<ControlWorkDTO> findAll();
}
