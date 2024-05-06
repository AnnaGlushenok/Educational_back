package create.create.mappers;

import create.create.dtos.SubjectDTO;
import create.create.models.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper interface for converting Subject entities to SubjectDTOs and lists of Subject entities to lists of SubjectDTOs.
 */
@Mapper(componentModel = "spring")
public interface SubjectMapper {
    /**
     * Converts a Subject entity to a SubjectDTO.
     *
     * @param subject The Subject entity to convert.
     * @return The corresponding SubjectDTO.
     */
    @Mapping(source = "image", target = "image")
    SubjectDTO toDTO(Subject subject);

    /**
     * Converts a list of Subject entities to a list of SubjectDTO.
     *
     * @param subjects The list of Subject entities to convert.
     * @return The list of corresponding SubjectDTO.
     */
    @Mapping(source = "image", target = "image")
    List<SubjectDTO> listToDTO(List<Subject> subjects);

    /**
     * Converts a SubjectDTO entity to a Subject.
     *
     * @param subjectDTO The SubjectDTO entity to convert.
     * @return The corresponding Subject.
     */
    @Mapping(source = "image", target = "image")
    Subject toEntity(SubjectDTO subjectDTO);

    /**
     * Converts a list of SubjectDTO entities to a list of Subject.
     *
     * @param subjectsDTO The list of SubjectDTO entities to convert.
     * @return The list of corresponding Subject.
     */
    @Mapping(source = "image", target = "image")
    List<Subject> lisToEntity(List<SubjectDTO> subjectsDTO);
}
