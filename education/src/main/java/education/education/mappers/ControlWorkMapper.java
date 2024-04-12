package education.education.mappers;

import education.education.dtos.ControlWorkDTO;
import education.education.models.ControlWork;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ControlWorkMapper {
    @Mapping(source = "questions", target = "questions")
    ControlWorkDTO toDTO(ControlWork controlWork);
}
