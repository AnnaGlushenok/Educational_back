package create.create.mappers;

import create.create.dtos.ControlWorkDTO;
import create.create.models.ControlWork;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper interface for converting ControlWork entities to ControlWorkDTOs and lists of ControlWork entities to lists of ControlWorkDTOs.
 */
@Mapper(componentModel = "spring", uses = QuestionMapper.class)
public interface ControlWorkMapper {
    /**
     * Converts a ControlWork entity to a ControlWorkDTO.
     *
     * @param controlWork The ControlWork entity to convert.
     * @return The corresponding ControlWorkDTO.
     */
    @Mapping(source = "questions", target = "questions")
    ControlWorkDTO toDTO(ControlWork controlWork);

    /**
     * Converts a list of ControlWork entities to a list of ControlWorkDTOs.
     *
     * @param controlWorks The list of ControlWork entities to convert.
     * @return The list of corresponding ControlWorkDTOs.
     */
    @Mapping(source = "questions", target = "questions")
    List<ControlWorkDTO> listToDTO(List<ControlWork> controlWorks);
}
