package education.education.mappers;

import education.education.dtos.ControlWorkDTO;
import education.education.models.ControlWork;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = QuestionMapper.class)
public interface ControlWorkMapper {
    @Mapping(source = "questions", target = "questions")
    ControlWorkDTO toDTO(ControlWork controlWork);

    @Mapping(source = "questions", target = "questions")
    List<ControlWorkDTO> listToDTO(List<ControlWork> aClass);
}
