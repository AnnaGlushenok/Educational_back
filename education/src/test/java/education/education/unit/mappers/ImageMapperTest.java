package education.education.unit.mappers;

import education.education.dtos.ImageDTO;
import education.education.mappers.ImageMapper;
import education.education.models.Image;
import education.education.repositories.ImageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@DataJpaTest
@SpringBootTest
public class ImageMapperTest {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ImageMapper imageMapper;

    @Test
    @DisplayName("Map image to dto")
    void test() {
        Image image = imageRepository.findById(2).get();
        ImageDTO imageDTO = imageMapper.toDTO(image);

        Assertions.assertNotNull(image);
        Assertions.assertNotNull(imageDTO);
        Assertions.assertEquals(imageDTO.getClass().getDeclaredFields().length, 3);
        Assertions.assertEquals(imageDTO.getId(), image.getId());
        Assertions.assertEquals(imageDTO.getName(), image.getName());
        Assertions.assertEquals(imageDTO.getAlt(), image.getAlt());
    }
}
