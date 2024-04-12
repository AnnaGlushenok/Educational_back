package education.education.services.interfaces;

import education.education.dtos.ClassDTO;
import education.education.dtos.SubjectDTO;
import education.education.dtos.UnitDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UnitProvider extends DataProvider<UnitDTO> {
    Map<SubjectDTO, Set<ClassDTO>> findAllClassesAndSubjects();

    List<UnitDTO> findAllBySubjectIdAndClassId(int subjectId, int classId);
}
