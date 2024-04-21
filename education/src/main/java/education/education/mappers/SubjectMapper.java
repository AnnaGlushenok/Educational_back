package education.education.mappers;

import education.education.dtos.SubjectDTO;
import education.education.models.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    @Mapping(source = "image", target = "image")
    SubjectDTO toDTO(Subject subject);

    @Mapping(source = "image", target = "image")
    List<SubjectDTO> listToDTO(List<Subject> subjects);
}
