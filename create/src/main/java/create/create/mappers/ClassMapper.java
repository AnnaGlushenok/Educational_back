package create.create.mappers;

import create.create.dtos.ClassDTO;
import create.create.models.Class;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper interface for converting Class entities to ClassDTOs and lists of Class entities to lists of ClassDTOs.
 */
@Mapper(componentModel = "spring")
public interface ClassMapper {
    /**
     * Converts a Class entity to a ClassDTO.
     *
     * @param aClass The Class entity to convert.
     * @return The corresponding ClassDTO.
     */
    ClassDTO toDTO(Class aClass);

    /**
     * Converts a list of Class entities to a list of ClassDTO.
     *
     * @param aClass The list of Class entities to convert.
     * @return The list of corresponding ClassDTO.
     */
    List<ClassDTO> listToDTO(List<Class> aClass);

    /**
     * Converts a ClassDTO entity to a Class.
     *
     * @param aClassDTO The ClassDTO entity to convert.
     * @return The corresponding Class.
     */
    Class toEntity(ClassDTO aClassDTO);

    /**
     * Converts a list of ClassDTO entities to a list of Class.
     *
     * @param aClassDTO The list of ClassDTO entities to convert.
     * @return The list of corresponding Class.
     */
    List<Class> listToEntity(List<ClassDTO> aClassDTO);
}
