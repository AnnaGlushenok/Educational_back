package education.education.services;

import education.education.dtos.ClassDTO;
import education.education.dtos.SubjectDTO;
import education.education.dtos.UnitDTO;
import education.education.mappers.UnitMapper;
import education.education.models.Class;
import education.education.models.Subject;
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
        return unitRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UnitDTO findById(int id) {
        return toDTO(unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit could not be found id=" + id)));
    }

    @Override
    public Map<SubjectDTO, Set<ClassDTO>> findAllClassesAndSubjects() {
//        TODO check if smth. null
        return unitRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.groupingBy(UnitDTO::getSubject,
                        Collectors.mapping(UnitDTO::getClassEntity, Collectors.toSet())));
    }

    @Override
    public List<UnitDTO> findAllBySubjectIdAndClassId(int subjectId, int classId) {
        return unitRepository.findAllBySubjectIdAndClassEntityId(subjectId, classId)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    //    @Override
    public List<UnitDTO> findAllParagraphsBySubjectIdAndClassId(int subjectId, int classId) {
        return null;
    }

    @Override
    public UnitDTO toDTO(Unit unit) {
        return unitMapper.toDTO(unit);
    }
}
