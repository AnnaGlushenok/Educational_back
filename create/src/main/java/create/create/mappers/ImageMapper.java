package create.create.mappers;

import create.create.dtos.ImageDTO;
import create.create.models.Image;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper interface for converting Image entities to ImageDTOs and lists of Image entities to lists of ImageDTOs.
 */
@Mapper(componentModel = "spring")
public interface ImageMapper {
    /**
     * Converts an Image entity to an ImageDTO.
     *
     * @param image The Image entity to convert.
     * @return The corresponding ImageDTO.
     */
    ImageDTO toDTO(Image image);

    /**
     * Converts a list of Image entities to a list of ImageDTOs.
     *
     * @param images The list of Image entities to convert.
     * @return The list of corresponding ImageDTOs.
     */
    List<ImageDTO> listToDTO(List<Image> images);
}
