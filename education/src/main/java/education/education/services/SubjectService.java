package education.education.services;

import education.education.dtos.SubjectDTO;
import education.education.mappers.SubjectMapper;
import education.education.models.Subject;
import education.education.repositories.SubjectRepository;
import education.education.services.interfaces.DataProvider;
import education.education.services.interfaces.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService implements DataProvider<SubjectDTO>, Mapper<SubjectDTO, Subject> {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<SubjectDTO> findAll() {
        return subjectRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDTO findById(int id) {
        return toDTO(subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Subject could not be found id=" + id)));
    }

    @Override
    public SubjectDTO toDTO(Subject subject) {
        return subjectMapper.toDTO(subject);
    }
}
