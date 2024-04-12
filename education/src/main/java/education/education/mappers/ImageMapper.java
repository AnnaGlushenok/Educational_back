package education.education.mappers;

import education.education.dtos.ImageDTO;
import education.education.models.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    ImageDTO toDTO(Image image);
}
