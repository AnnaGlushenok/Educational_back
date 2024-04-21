package education.education.mappers;

import education.education.dtos.UnitDTO;
import education.education.models.Unit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = TestMapper.class)
public interface UnitMapper {
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "classEntity", target = "classEntity")
    @Mapping(source = "test", target = "test")
    @Mapping(source = "controlWork", target = "controlWork")
    @Mapping(source = "paragraphs", target = "paragraphs")
    UnitDTO toDTO(Unit unit);

    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "classEntity", target = "classEntity")
    @Mapping(source = "test", target = "test")
    @Mapping(source = "controlWork", target = "controlWork")
    @Mapping(source = "paragraphs", target = "paragraphs")
    List<UnitDTO> listToDTO(List<Unit> unit);
}
