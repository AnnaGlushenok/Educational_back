package education.education.services;

import education.education.models.ControlWork;
import education.education.repositories.ControlWorkRepository;
import education.education.services.interfaces.DataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ControlWorkService implements DataProvider<ControlWork> {
    @Autowired
    private ControlWorkRepository controlWorkRepository;

    @Override
    public List<ControlWork> findAll() {
        return controlWorkRepository.findAll();
    }

    @Override
    public ControlWork findById(int id) {
        ControlWork сontrolWork = controlWorkRepository.findById(id).orElseThrow(() -> new RuntimeException("ControlWork could not be found id="+id));
        return сontrolWork;
    }
}
