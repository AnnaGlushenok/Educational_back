package create.create.services;

import create.create.dtos.SubjectDTO;
import create.create.mappers.SubjectMapper;
import create.create.models.Subject;
import create.create.repositories.SubjectRepository;
import create.create.services.interfaces.Mapper;
import create.create.services.interfaces.SubjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class implementing the SubjectProvider interface and Mapper for SubjectDTO and Subject entities.
 * Allows to perform operations on entities.
 */
//TODO нужен ли?
@Service
public class SubjectService implements SubjectProvider, Mapper<SubjectDTO, Subject> {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectMapper subjectMapper;

    /**
     * Converts a Subject entity to a SubjectDTO using the SubjectMapper.
     *
     * @param subject The Subject entity to convert.
     * @return The corresponding SubjectDTO.
     */
    @Override
    public SubjectDTO toDTO(Subject subject) {
        return subjectMapper.toDTO(subject);
    }

    /**
     * Converts a list of Subject entities to a list of SubjectDTOs using the SubjectMapper.
     *
     * @param list The list of Subject entities to convert.
     * @return The list of corresponding SubjectDTO.
     */
    @Override
    public List<SubjectDTO> listToDTO(List<Subject> list) {
        return subjectMapper.listToDTO(list);
    }
}
