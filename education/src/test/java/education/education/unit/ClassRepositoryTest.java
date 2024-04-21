package education.education.unit;


import education.education.models.Class;
import education.education.repositories.ClassRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ClassRepositoryTest {
    @Autowired
    private ClassRepository classRepository;
    private final int ID = 1;
    private final List<Class> classes = new ArrayList<>() {{
        add(Class.builder().name("class1").build());
        add(Class.builder().name("class2").build());
        add(Class.builder().name("class3").build());
    }};

    @BeforeEach
    public void saveData() {
        classRepository.saveAll(classes);
    }

    @AfterEach
    public void clearData() {
        classRepository.deleteAll();
    }

    @Test
    @DisplayName("Get all classes")
    public void getAll() {
        List<Class> savedClasses = classRepository.findAll();

        Assertions.assertThat(classes.size()).isEqualTo(savedClasses.size());
        for (int i = 0; i < classes.size(); i++)
            test(savedClasses.get(i), classes.get(i));
    }

    @Test
    @DisplayName("Save 1 class")
    public void save() {
        Class classEntity = classes.get(0);
        Class savedClass1 = classRepository.save(classEntity);
        test(classEntity, savedClass1);
    }

    @Test
    @DisplayName("find class by id")
    public void findById() {
        Class classEntity1 = classRepository.findById(ID).get();
        test(classEntity1, classes.get(ID - 1));

        Assertions.assertThatThrownBy(() -> classRepository.findById(6).get())
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("Update class")
    public void update() {
        Class savedClass1 = classRepository.findById(ID).get();
        savedClass1.setName("newName");
        Class updatedClass = classRepository.save(savedClass1);
        test(savedClass1, updatedClass);
    }

    @Test
    @DisplayName("Delete class")
    public void delete() {
        classRepository.deleteById(1);
        Optional<Class> class2 = classRepository.findById(ID);
        Assertions.assertThat(class2).isEmpty();
    }

    public void test(Class classEntity1, Class classEntity2) {
        Assertions.assertThat(classEntity1).isNotNull();
        Assertions.assertThat(classEntity1.getId()).isEqualTo(classEntity2.getId());
        Assertions.assertThat(classEntity1.getName()).isEqualTo(classEntity2.getName());
    }
}
