package create.create.services;

import create.create.dtos.ParagraphDTO;
import create.create.mappers.ParagraphMapper;
import create.create.models.Paragraph;
import create.create.repositories.ParagraphRepository;
import create.create.services.interfaces.Mapper;
import create.create.services.interfaces.ParagraphProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class implementing the ParagraphProvider interface and Mapper for ParagraphDTO and Paragraph entities.
 * Allows to perform operations on entities.
 */
@Service
public class ParagraphService implements ParagraphProvider, Mapper<ParagraphDTO, Paragraph> {
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
        return toDTO(paragraphRepository.findById(id).orElseThrow(() -> new RuntimeException("Paragraph could not be found id=" + id)));
    }

    /**
     * Converts a Paragraph entity to a ParagraphDTO using the ParagraphMapper.
     *
     * @param paragraph The Paragraph entity to convert.
     * @return The corresponding ParagraphDTO.
     */
    @Override
    public ParagraphDTO toDTO(Paragraph paragraph) {
        return paragraphMapper.toDTO(paragraph);
    }

    /**
     * Converts a list of Paragraph entities to a list of ParagraphDTOs using the ParagraphMapper.
     *
     * @param list The list of Paragraph entities to convert.
     * @return The list of corresponding ParagraphDTOs.
     */
    @Override
    public List<ParagraphDTO> listToDTO(List<Paragraph> list) {
        return paragraphMapper.listToDTO(list);
    }
}
