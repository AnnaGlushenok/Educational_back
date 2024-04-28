package education.education.services.interfaces;

import education.education.dtos.ClassDTO;
import education.education.dtos.SubjectDTO;
import education.education.dtos.UnitDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The UnitProvider interface extends the DataProvider interface to provide methods specific to managing UnitDTO objects.
 * It also includes additional methods for retrieving classes and subjects related to units.
 */
public interface UnitProvider extends DataProvider<UnitDTO> {
    /**
     * Retrieves a mapping of subjects to sets of classes.
     *
     * @return a map where each subject (key) is associated with a set of classes (value)
     */
    Map<SubjectDTO, Set<ClassDTO>> findAllClassesAndSubjects();

    /**
     * Retrieves a list of UnitDTO objects based on the given subject ID and class ID.
     *
     * @param subjectId The ID of the subject for which units are being retrieved.
     * @param classId   The ID of the class for which units are being retrieved.
     * @return A list of UnitDTO objects corresponding to the specified subject ID and class ID.
     */
    List<UnitDTO> findUnitsBySubjectIdAndClassId(int subjectId, int classId);
}
