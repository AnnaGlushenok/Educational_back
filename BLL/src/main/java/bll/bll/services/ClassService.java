package bll.bll.services;

import dal.dal.interfases.ClassRepository;
import dal.dal.models.Class;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public Iterable<Class> get() {
        var r = classRepository.findAll();
        return r;
    }
}
