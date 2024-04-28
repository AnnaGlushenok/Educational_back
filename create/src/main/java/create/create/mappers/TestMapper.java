package create.create.mappers;

import create.create.dtos.TestDTO;
import create.create.models.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper interface for converting Test entities to TestDTOs and vice versa.
 */
@Mapper(componentModel = "spring", uses = QuestionMapper.class)
public interface TestMapper {
    /**
     * Converts a list of Test entities to a list of TestDTOs.
     *
     * @param tests The list of Test entities to convert.
     * @return The list of corresponding TestDTOs.
     */
    List<TestDTO> listToDTO(List<Test> tests);

    /**
     * Converts a Test entity to a TestDTO.
     *
     * @param test The Test entity to convert.
     * @return The corresponding TestDTO.
     */
    @Mapping(source = "questions", target = "questions")
    @Mapping(source = "final", target = "isFinal")
    TestDTO toDTO(Test test);
}
