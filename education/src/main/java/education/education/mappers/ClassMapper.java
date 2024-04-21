package education.education.mappers;

import education.education.dtos.ClassDTO;
import education.education.models.Class;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassMapper {
    ClassDTO toDTO(Class aClass);

    List<ClassDTO> listToDTO(List<Class> aClass);
}
