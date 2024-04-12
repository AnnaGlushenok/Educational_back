package education.education.mappers;

import education.education.dtos.UnitDTO;
import education.education.models.Unit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UnitMapper {
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "classEntity", target = "classEntity")
    @Mapping(source = "test", target = "test")
    @Mapping(source = "controlWork", target = "controlWork")
    @Mapping(source = "paragraphs", target = "paragraphs")
    UnitDTO toDTO(Unit unit);
}
