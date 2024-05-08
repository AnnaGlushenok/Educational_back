package education.education.services;

import education.education.dtos.ParagraphDTO;
import education.education.mappers.ParagraphMapper;
import education.education.models.Paragraph;
import education.education.repositories.ParagraphRepository;
import education.education.services.interfaces.ParagraphProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class implementing the ParagraphProvider interface.
 * Allows to perform operations on entities.
 */
@Service
public class ParagraphService implements ParagraphProvider {
    @Autowired
    private ParagraphRepository paragraphRepository;
    @Autowired
    private ParagraphMapper paragraphMapper;

    /**
     * Retrieves a ParagraphDTO object by its ID.
     *
     * @param id The ID of the paragraph to retrieve.
     * @return The ParagraphDTO object corresponding to the specified ID.
     * @throws RuntimeException if the paragraph with the given ID is not found.
     */
    @Override
    public ParagraphDTO findById(int id) {
        return paragraphMapper.toDTO(paragraphRepository.findById(id).orElseThrow(() -> new RuntimeException("Paragraph could not be found id=" + id)));
    }
}
