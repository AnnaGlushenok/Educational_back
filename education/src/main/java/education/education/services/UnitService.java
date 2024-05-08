package education.education.services;

import education.education.dtos.ClassDTO;
import education.education.dtos.SubjectDTO;
import education.education.dtos.UnitDTO;
import education.education.mappers.UnitMapper;
import education.education.repositories.UnitRepository;
import education.education.services.interfaces.UnitProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service class implementing the UnitProvider interface.
 */
@Service
public class UnitService implements UnitProvider {
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private UnitMapper unitMapper;

    /**
     * Retrieves all classes and their associated subjects.
     *
     * @return A Map where each SubjectDTO is mapped to a set of ClassDTOs representing the classes related to that subject.
     */
    @Override
    public Map<SubjectDTO, Set<ClassDTO>> findAllClassesAndSubjects() {
//        TODO check if smth. null
        return unitMapper.listToDTO(unitRepository.findAll())
                .stream()
                .collect(Collectors.groupingBy(UnitDTO::getSubject,
                        Collectors.mapping(UnitDTO::getClassEntity, Collectors.toSet())));
    }

    /**
     * Retrieves a list of UnitDTO objects based on the given subject ID and class ID.
     *
     * @param subjectId The ID of the subject.
     * @param classId   The ID of the class.
     * @return A list of UnitDTO objects that belong to the specified subject and class.
     */
    @Override
    public List<UnitDTO> findUnitsBySubjectIdAndClassId(int subjectId, int classId) {
        return unitMapper.listToDTO(unitRepository.findAllBySubjectIdAndClassEntityId(subjectId, classId));
    }
}
