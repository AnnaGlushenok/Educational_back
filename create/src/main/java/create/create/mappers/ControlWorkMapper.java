package create.create.mappers;

import create.create.dtos.ControlWorkDTO;
import create.create.models.ControlWork;
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
