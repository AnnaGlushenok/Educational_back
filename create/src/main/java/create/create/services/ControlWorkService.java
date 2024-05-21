package create.create.services;

import create.create.dtos.ControlWorkDTO;
import create.create.mappers.ControlWorkMapper;
import create.create.repositories.ControlWorkRepository;
import create.create.services.interfaces.ControlWorkProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class implementing the ControlWorkProvider interface.
 * Allows to perform operations on entities.
 */
@Service
public class ControlWorkService implements ControlWorkProvider  {
    @Autowired
    private ControlWorkRepository controlWorkRepository;
    @Autowired
    private ControlWorkMapper controlWorkMapper;

    /**
     * Retrieves all ControlWorkDTO objects.
     *
     * @return A list of ControlWorkDTO objects representing all available control works.
     */
    @Override
    public List<ControlWorkDTO> findAll() {
        return controlWorkMapper.listToDTO(controlWorkRepository.findAll());
    }
}
