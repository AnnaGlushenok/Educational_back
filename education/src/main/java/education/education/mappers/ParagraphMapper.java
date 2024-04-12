package education.education.mappers;

import education.education.dtos.ParagraphDTO;
import education.education.models.Paragraph;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ParagraphMapper {
    @Mapping(source = "questions", target = "questions")
    @Mapping(source = "tests", target = "tests")
    @Mapping(source = "controlWorks", target = "controlWorks")
    ParagraphDTO toDTO(Paragraph paragraph);
}
