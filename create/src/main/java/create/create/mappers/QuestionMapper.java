package create.create.mappers;

import create.create.dtos.QuestionDTO;
import create.create.models.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper interface for converting Question entities to QuestionDTOs and lists of Question entities to lists of QuestionDTOs.
 */
@Mapper(componentModel = "spring")
public interface QuestionMapper {
    /**
     * Converts a Question entity to a QuestionDTO.
     *
     * @param question The Question entity to convert.
     * @return The corresponding QuestionDTO.
     */
    @Mapping(source = "questionType", target = "questionType")
    QuestionDTO toDTO(Question question);

    /**
     * Converts a list of Question entities to a list of QuestionDTOs.
     *
     * @param questions The list of Question entities to convert.
     * @return The list of corresponding QuestionDTOs.
     */
    @Mapping(source = "questionType", target = "questionType")
    List<QuestionDTO> listToDTO(List<Question> questions);

    /**
     * Converts a QuestionDTO entity to a Question.
     *
     * @param questionDTO The QuestionDTO entity to convert.
     * @return The corresponding Question.
     */
    @Mapping(source = "questionType", target = "questionType")
    Question toEntity(QuestionDTO questionDTO);

    /**
     * Converts a list of QuestionDTO entities to a list of Question.
     *
     * @param questionsDTO The list of QuestionDTO entities to convert.
     * @return The list of corresponding Question.
     */
    @Mapping(source = "questionType", target = "questionType")
    List<Question> listToEntity(List<QuestionDTO> questionsDTO);
}
