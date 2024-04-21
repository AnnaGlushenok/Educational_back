package education.education.services;

import education.education.dtos.ImageDTO;
import education.education.mappers.ImageMapper;
import education.education.models.Image;
import education.education.repositories.ImageRepository;
import education.education.services.interfaces.DataProvider;
import education.education.services.interfaces.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements DataProvider<Image>, Mapper<ImageDTO, Image> {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ImageMapper imageMapper;

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image findById(int id) {
        Image image = imageRepository.findById(id).orElseThrow(() -> new RuntimeException("ControlWork could not be found id=" + id));
        return image;
    }

    @Override
    public ImageDTO toDTO(Image image) {
        return imageMapper.toDTO(image);
    }

    @Override
    public List<ImageDTO> listToDTO(List<Image> u) {
        return null;
    }
}
