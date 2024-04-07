package education.education.mappers;

import education.education.dtos.ImageDTO;
import education.education.models.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    //   @Mapping(source = "image", target = "image")
    ImageDTO toDTO(Image image);

//    @Mapping(source = "image", target = "image")
//    Image toEntity(ImageDTO imageDTO);
}
