package education.education.services;

import education.education.dtos.ParagraphDTO;
import education.education.mappers.ParagraphMapper;
import education.education.models.Paragraph;
import education.education.repositories.ParagraphRepository;
import education.education.services.interfaces.DataProvider;
import education.education.services.interfaces.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParagraphService implements DataProvider<ParagraphDTO>, Mapper<ParagraphDTO, Paragraph> {
    @Autowired
    private ParagraphRepository paragraphRepository;
    @Autowired
    private ParagraphMapper paragraphMapper;

    @Override
    public List<ParagraphDTO> findAll() {
        return listToDTO(paragraphRepository.findAll());
    }

    @Override
    public ParagraphDTO findById(int id) {
        return toDTO(paragraphRepository.findById(id).orElseThrow(() -> new RuntimeException("Paragraph could not be found id=" + id)));
    }

    @Override
    public ParagraphDTO toDTO(Paragraph paragraph) {
        return paragraphMapper.toDTO(paragraph);
    }

    @Override
    public List<ParagraphDTO> listToDTO(List<Paragraph> list) {
        return paragraphMapper.listToDTO(list);
    }
}
