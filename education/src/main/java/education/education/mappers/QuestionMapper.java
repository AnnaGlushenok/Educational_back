package education.education.mappers;

import education.education.dtos.QuestionDTO;
import education.education.models.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionDTO toDTO(Question question);
}
