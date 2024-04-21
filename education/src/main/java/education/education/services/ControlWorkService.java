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
public class ControlWorkService implements DataProvider<ControlWorkDTO>, Mapper<ControlWorkDTO, ControlWork> {
    @Autowired
    private ControlWorkRepository controlWorkRepository;
    @Autowired
    private ControlWorkMapper controlWorkMapper;

    @Override
    public List<ControlWorkDTO> findAll() {
        return listToDTO(controlWorkRepository.findAll());
    }

    @Override
    public ControlWorkDTO findById(int id) {
        ControlWorkDTO сontrolWork = toDTO(controlWorkRepository.findById(id).orElseThrow(() -> new RuntimeException("ControlWork could not be found id=" + id)));
        return сontrolWork;
    }

    @Override
    public ControlWorkDTO toDTO(ControlWork controlWork) {
        return controlWorkMapper.toDTO(controlWork);
    }

    @Override
    public List<ControlWorkDTO> listToDTO(List<ControlWork> list) {
        return controlWorkMapper.listToDTO(list);
    }
}
