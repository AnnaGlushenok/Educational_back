package create.create.mappers;

import create.create.dtos .QuestionDTO;
import create.create.models.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(source = "questionType", target = "questionType")
    QuestionDTO toDTO(Question question);

    @Mapping(source = "questionType", target = "questionType")
    List<QuestionDTO> listToDTO(List<Question> questions);
}
