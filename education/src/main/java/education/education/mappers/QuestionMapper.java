package education.education.mappers;

import education.education.dtos.QuestionDTO;
import education.education.models.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionDTO toDTO(Question question);

    List<QuestionDTO> listToDTO(List<Question> questions);
}
