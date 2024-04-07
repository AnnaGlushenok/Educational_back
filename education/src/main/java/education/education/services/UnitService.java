package education.education.services;

import education.education.models.Unit;
import education.education.repositories.UnitRepository;
import education.education.services.interfaces.DataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService implements DataProvider<Unit> {
    @Autowired
    private UnitRepository unitRepository;

    @Override
    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    @Override
    public Unit findById(int id) {
        Unit unit = unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit could not be found id=" + id));
        return unit;
    }
}
