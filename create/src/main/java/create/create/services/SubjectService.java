package create.create.services;

import create.create.mappers.SubjectMapper;
import create.create.repositories.SubjectRepository;
import create.create.services.interfaces.SubjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class implementing the SubjectProvider interface.
 * Allows to perform operations on entities.
 */
//TODO нужен ли?
@Service
public class SubjectService implements SubjectProvider{
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectMapper subjectMapper;
}
