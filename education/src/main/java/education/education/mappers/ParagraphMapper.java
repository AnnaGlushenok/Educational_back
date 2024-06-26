package education.education.mappers;

import education.education.dtos.ParagraphDTO;
import education.education.models.Paragraph;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper interface for converting Paragraph entities to ParagraphDTOs and vice versa.
 */
@Mapper(componentModel = "spring", uses = TestMapper.class)
public interface ParagraphMapper {
    /**
     * Converts a Paragraph entity to a ParagraphDTO.
     *
     * @param paragraph The Paragraph entity to convert.
     * @return The corresponding ParagraphDTO.
     */
    @Mapping(source = "questions", target = "questions")
    @Mapping(source = "tests", target = "tests")
    @Mapping(source = "controlWorks", target = "controlWorks")
    ParagraphDTO toDTO(Paragraph paragraph);

    /**
     * Converts a list of Paragraph entities to a list of ParagraphDTOs.
     *
     * @param paragraphs The list of Paragraph entities to convert.
     * @return The list of corresponding ParagraphDTOs.
     */
    @Mapping(source = "questions", target = "questions")
    @Mapping(source = "tests", target = "tests")
    @Mapping(source = "controlWorks", target = "controlWorks")
    List<ParagraphDTO> listToDTO(List<Paragraph> paragraphs);
}
