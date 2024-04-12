package education.education.mappers;

import education.education.dtos.TestDTO;
import education.education.models.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TestMapper {
    @Mapping(source = "questions", target = "questions")
    TestDTO toDTO(Test test);
}
