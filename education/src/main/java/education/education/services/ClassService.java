package education.education.services;

import education.education.models.Class;
import education.education.repositories.ClassRepository;
import education.education.services.interfaces.DataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements DataProvider<Class> {
    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<Class> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Class findById(int id) {
        Class aClass = classRepository.findById(id).orElseThrow(() -> new RuntimeException("Class could not be found id="+id));
        return aClass;
    }
}
