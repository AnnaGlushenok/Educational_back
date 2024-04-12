package education.education.services;

import education.education.dtos.ControlWorkDTO;
import education.education.mappers.ControlWorkMapper;
import education.education.models.ControlWork;
import education.education.repositories.ControlWorkRepository;
import education.education.services.interfaces.DataProvider;
import education.education.services.interfaces.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlWorkService implements DataProvider<ControlWork>, Mapper<ControlWorkDTO, ControlWork> {
    @Autowired
    private ControlWorkRepository controlWorkRepository;
    @Autowired
    private ControlWorkMapper controlWorkMapper;

    @Override
    public List<ControlWork> findAll() {
        return controlWorkRepository.findAll();
    }

    @Override
    public ControlWork findById(int id) {
        ControlWork сontrolWork = controlWorkRepository.findById(id).orElseThrow(() -> new RuntimeException("ControlWork could not be found id=" + id));
        return сontrolWork;
    }

    @Override
    public ControlWorkDTO toDTO(ControlWork controlWork) {
        return controlWorkMapper.toDTO(controlWork);
    }
}
