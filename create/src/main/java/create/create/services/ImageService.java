package create.create.services;

import create.create.dtos.ImageDTO;
import create.create.mappers.ImageMapper;
import create.create.models.Image;
import create.create.repositories.ImageRepository;
import create.create.services.interfaces.ImageProvider;
import create.create.services.interfaces.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class implementing the ImageProvider interface and Mapper for ImageDTO and Image entities.
 * Allows to perform operations on entities.
 */
@Service
public class ImageService implements ImageProvider, Mapper<ImageDTO, Image> {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ImageMapper imageMapper;

    /**
     * Converts an Image entity to a ImageDTO using the ImageMapper.
     *
     * @param image The Image entity to convert.
     * @return The corresponding ImageDTO.
     */
    @Override
    public ImageDTO toDTO(Image image) {
        return imageMapper.toDTO(image);
    }

    /**
     * Converts a list of Image entities to a list of ImageDTOs using the ImageMapper.
     *
     * @param list The list of Image entities to convert.
     * @return The list of corresponding ImageDTOs.
     */
    @Override
    public List<ImageDTO> listToDTO(List<Image> list) {
        return imageMapper.listToDTO(list);
    }
}
