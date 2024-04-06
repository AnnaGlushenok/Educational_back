package education.education.unit;


import education.education.models.Class;
import education.education.repositories.ClassRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ClassRepositoryTest {
    @Autowired
    private ClassRepository classRepository;

    @Test
    @DisplayName("Save 1 class")
    public void save() {
        Class class1 = Class.builder()
                .name("class1")
                .build();
        Class savedClass1 = classRepository.save(class1);

        Assertions.assertThat(savedClass1).isNotNull();
        Assertions.assertThat(savedClass1.getName()).isEqualTo(class1.getName());
    }

    @Test
    @DisplayName("Get all classes")
    public void getAll() {
        List<Class> classes = new ArrayList<>() {{
            add(Class.builder().name("class1").build());
            add(Class.builder().name("class2").build());
            add(Class.builder().name("class3").build());
        }};

        List<Class> savedClasses = classRepository.saveAll(classes);

        Assertions.assertThat(classes.size()).isEqualTo(savedClasses.size());

        for (int i = 0; i < classes.size(); i++) {
            Assertions.assertThat(savedClasses.get(i)).isNotNull();
            Assertions.assertThat(savedClasses.get(i).getName()).isEqualTo(classes.get(i).getName());
        }
    }

    @Test
    @DisplayName("Update class")
    public void update() {
        Class class1 = Class.builder()
                .name("class1")
                .build();
        classRepository.save(class1);

        Class savedClass1 = classRepository.findById(class1.getId()).get();
        savedClass1.setName("newName");
        Class updatedClass = classRepository.save(savedClass1);

        Assertions.assertThat(updatedClass).isNotNull();
        Assertions.assertThat(updatedClass.getName()).isEqualTo(savedClass1.getName());
    }

    @Test
    @DisplayName("Delete class")
    public void delete() {
        Class class1 = Class.builder()
                .name("class1")
                .build();
        classRepository.save(class1);

        classRepository.deleteById(class1.getId());
        Optional<Class> class2 = classRepository.findById(class1.getId());

        Assertions.assertThat(class2).isEmpty();
    }
}
