package education.education.services;

import education.education.dtos.ClassDTO;
import education.education.dtos.SubjectDTO;
import education.education.dtos.UnitDTO;
import education.education.mappers.UnitMapper;
import education.education.models.Unit;
import education.education.repositories.UnitRepository;
import education.education.services.interfaces.Mapper;
import education.education.services.interfaces.UnitProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UnitService implements UnitProvider, Mapper<UnitDTO, Unit> {
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private UnitMapper unitMapper;

    @Override
    public List<UnitDTO> findAll() {
        return listToDTO(unitRepository.findAll());
    }

    @Override
    public UnitDTO findById(int id) {
        return toDTO(unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit could not be found id=" + id)));
    }

    @Override
    public Map<SubjectDTO, Set<ClassDTO>> findAllClassesAndSubjects() {
//        TODO check if smth. null
        return listToDTO(unitRepository.findAll())
                .stream()
                .collect(Collectors.groupingBy(UnitDTO::getSubject,
                        Collectors.mapping(UnitDTO::getClassEntity, Collectors.toSet())));
    }

    @Override
    public List<UnitDTO> findUnitsAndParagraphsBySubjectIdAndClassId(int subjectId, int classId) {
        return listToDTO(unitRepository.findAllBySubjectIdAndClassEntityId(subjectId, classId));
    }

    @Override
    public UnitDTO toDTO(Unit unit) {
        return unitMapper.toDTO(unit);
    }

    @Override
    public List<UnitDTO> listToDTO(List<Unit> list) {
        return unitMapper.listToDTO(list);
    }
}
