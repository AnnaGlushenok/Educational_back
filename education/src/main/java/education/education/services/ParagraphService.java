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
import java.util.stream.Collectors;

@Service
public class ParagraphService implements DataProvider<ParagraphDTO>, Mapper<ParagraphDTO, Paragraph> {
    @Autowired
    private ParagraphRepository paragraphRepository;
    @Autowired
    private ParagraphMapper paragraphMapper;

    @Override
    public List<ParagraphDTO> findAll() {
        return paragraphRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParagraphDTO findById(int id) {
        return toDTO(paragraphRepository.findById(id).orElseThrow(() -> new RuntimeException("Paragraph could not be found id=" + id)));
    }

    public ParagraphDTO toDTO(Paragraph paragraph) {
        return paragraphMapper.toDTO(paragraph);
    }
}
