package create.create.services;

import create.create.mappers.ImageMapper;
import create.create.repositories.ImageRepository;
import create.create.services.interfaces.ImageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class implementing the ImageProvider interface.
 * Allows to perform operations on entities.
 */
@Service
public class ImageService implements ImageProvider {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ImageMapper imageMapper;
}
