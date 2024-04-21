package education.education.services;

import education.education.dtos.ClassDTO;
import education.education.mappers.ClassMapper;
import education.education.models.Class;
import education.education.repositories.ClassRepository;
import education.education.services.interfaces.ClassProvider;
import education.education.services.interfaces.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements ClassProvider, Mapper<ClassDTO, Class> {
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private ClassMapper classMapper;

    @Override
    public List<ClassDTO> findAll() {
        return listToDTO(classRepository.findAll());
    }

    @Override
    public ClassDTO findById(int id) {
        return toDTO(classRepository.findById(id).orElseThrow(() -> new RuntimeException("Class could not be found id=" + id)));
    }

    @Override
    public ClassDTO toDTO(Class classEntity) {
        return classMapper.toDTO(classEntity);
    }

    @Override
    public List<ClassDTO> listToDTO(List<Class> list) {
        return classMapper.listToDTO(list);
    }
}
