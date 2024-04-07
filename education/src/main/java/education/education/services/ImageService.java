package education.education.services;

import education.education.models.Image;
import education.education.repositories.ImageRepository;
import education.education.services.interfaces.DataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService implements DataProvider<Image> {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image findById(int id) {
        Image image = imageRepository.findById(id).orElseThrow(() -> new RuntimeException("ControlWork could not be found id=" + id));
        return image;
    }
}
