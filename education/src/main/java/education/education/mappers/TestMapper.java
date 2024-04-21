package education.education.mappers;

import education.education.dtos.TestDTO;
import education.education.models.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TestMapper {
    List<TestDTO> listToDTO(List<Test> tests);

    @Mapping(source = "questions", target = "questions")
    @Mapping(source = "final", target = "isFinal")
    TestDTO toDTO(Test test);
}
