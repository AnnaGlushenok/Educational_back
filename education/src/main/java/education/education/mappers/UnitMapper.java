package education.education.mappers;

import education.education.dtos.UnitDTO;
import education.education.models.Unit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper interface for converting Unit entities to UnitDTOs and vice versa.
 */
@Mapper(componentModel = "spring", uses = {TestMapper.class, QuestionMapper.class})
public interface UnitMapper {
    /**
     * Converts a Unit entity to a UnitDTO.
     *
     * @param unit The Unit entity to convert.
     * @return The corresponding UnitDTO.
     */
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "classEntity", target = "classEntity")
    @Mapping(source = "test", target = "test")
    @Mapping(source = "controlWork", target = "controlWork")
    @Mapping(source = "paragraphs", target = "paragraphs")
    UnitDTO toDTO(Unit unit);

    /**
     * Converts a list of Unit entities to a list of UnitDTOs.
     *
     * @param unit The list of Unit entities to convert.
     * @return The list of corresponding UnitDTOs.
     */
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "classEntity", target = "classEntity")
    @Mapping(source = "test", target = "test")
    @Mapping(source = "controlWork", target = "controlWork")
    @Mapping(source = "paragraphs", target = "paragraphs")
    List<UnitDTO> listToDTO(List<Unit> unit);
}
