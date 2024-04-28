package create.create.services;

import create.create.dtos.ClassDTO;
import create.create.dtos.SubjectDTO;
import create.create.dtos.UnitDTO;
import create.create.mappers.UnitMapper;
import create.create.models.Unit;
import create.create.repositories.UnitRepository;
import create.create.services.interfaces.Mapper;
import create.create.services.interfaces.UnitProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service class implementing the UnitProvider interface and Mapper for UnitDTO and Unit entities.
 */
@Service
public class UnitService implements UnitProvider, Mapper<UnitDTO, Unit> {
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private UnitMapper unitMapper;

    /**
     * Retrieves all classes and their associated subjects.
     *
     * @return A map where each SubjectDTO is mapped to a set of ClassDTOs representing the classes related to that subject.
     */
    @Override
    public Map<SubjectDTO, Set<ClassDTO>> findAllClassesAndSubjects() {
//        TODO check if smth. null
        return listToDTO(unitRepository.findAll())
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
        return listToDTO(unitRepository.findAllBySubjectIdAndClassEntityId(subjectId, classId));
    }

    /**
     * Converts a Unit entity to a UnitDTO using the UnitMapper.
     *
     * @param unit The Unit entity to convert.
     * @return The corresponding UnitDTO.
     */
    @Override
    public UnitDTO toDTO(Unit unit) {
        return unitMapper.toDTO(unit);
    }

    /**
     * Converts a list of Unit entities to a list of UnitDTOs using the UnitMapper.
     *
     * @param list The list of Unit entities to convert.
     * @return The list of corresponding UnitDTOs.
     */
    @Override
    public List<UnitDTO> listToDTO(List<Unit> list) {
        return unitMapper.listToDTO(list);
    }
}
