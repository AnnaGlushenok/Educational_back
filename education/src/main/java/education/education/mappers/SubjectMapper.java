package education.education.mappers;

import education.education.dtos.SubjectDTO;
import education.education.models.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    @Mapping(source = "image", target = "image")
    SubjectDTO toDTO(Subject subject);

//      @Mapping(source = "image", target = "image")
//    Subject toEntity(SubjectDTO subjectDTO);
}
