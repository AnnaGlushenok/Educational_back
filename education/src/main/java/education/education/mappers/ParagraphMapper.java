package education.education.mappers;

import education.education.dtos.ParagraphDTO;
import education.education.models.Paragraph;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = TestMapper.class)
public interface ParagraphMapper {
    @Mapping(source = "questions", target = "questions")
    @Mapping(source = "tests", target = "tests")
    @Mapping(source = "controlWorks", target = "controlWorks")
//    @Mapping(target = "isFinal", expression = "java(mapTest(paragraph.getTests()))")
//    @Mapping(target = "tests.isFinal", source = "tests")
    ParagraphDTO toDTO(Paragraph paragraph);

    @Mapping(source = "questions", target = "questions")
    @Mapping(source = "tests", target = "tests")
    @Mapping(source = "controlWorks", target = "controlWorks")
        // @Mapping(target = "isFinal", expression = "java(isFinal(paragraph.getTests()))")
    List<ParagraphDTO> listToDTO(List<Paragraph> paragraphs);
}
