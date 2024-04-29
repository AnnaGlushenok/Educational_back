package create.create.services;

import create.create.dtos.ControlWorkDTO;
import create.create.mappers.ControlWorkMapper;
import create.create.models.ControlWork;
import create.create.repositories.ControlWorkRepository;
import create.create.services.interfaces.ControlWorkProvider;
import create.create.services.interfaces.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class implementing the ControlWorkProvider interface and Mapper for ControlWorkDTO and ControlWork entities.
 * Allows to perform operations on entities.
 */
@Service
public class ControlWorkService implements ControlWorkProvider, Mapper<ControlWorkDTO, ControlWork> {
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
        return listToDTO(controlWorkRepository.findAll());
    }

    /**
     * Converts a ControlWork entity to a ControlWorkDTO using the ControlWorkMapper.
     *
     * @param controlWork The ControlWork entity to convert.
     * @return The corresponding ControlWorkDTO.
     */
    @Override
    public ControlWorkDTO toDTO(ControlWork controlWork) {
        return controlWorkMapper.toDTO(controlWork);
    }

    /**
     * Converts a list of ControlWork entities to a list of ControlWorkDTOs using the ControlWorkMapper.
     *
     * @param list The list of ControlWork entities to convert.
     * @return The list of corresponding ControlWorkDTOs.
     */
    @Override
    public List<ControlWorkDTO> listToDTO(List<ControlWork> list) {
        return controlWorkMapper.listToDTO(list);
    }


}
