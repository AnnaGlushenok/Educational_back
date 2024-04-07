package education.education.mappers;

import education.education.dtos.ImageDTO;
import education.education.models.Image;
import org.mapstruct.Mapper;

@Mapper
public interface ImageMapper {
    ImageDTO toDTO(Image image);

    Image toEntity(ImageDTO imageDTO);
}
