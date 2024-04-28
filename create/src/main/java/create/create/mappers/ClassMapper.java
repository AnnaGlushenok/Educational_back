package create.create.mappers;

import create.create.dtos.ClassDTO;
import create.create.models.Class;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassMapper {
    ClassDTO toDTO(Class aClass);

    List<ClassDTO> listToDTO(List<Class> aClass);
}
