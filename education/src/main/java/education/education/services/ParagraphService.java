package education.education.services;

import education.education.models.Paragraph;
import education.education.repositories.ParagraphRepository;
import education.education.services.interfaces.DataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParagraphService implements DataProvider<Paragraph> {
    @Autowired
    private ParagraphRepository paragraphRepository;

    @Override
    public List<Paragraph> findAll() {
        return paragraphRepository.findAll();
    }

    @Override
    public Paragraph findById(int id) {
        Paragraph paragraph = paragraphRepository.findById(id).orElseThrow(() -> new RuntimeException("Paragraph could not be found id=" + id));
        return paragraph;
    }
}
