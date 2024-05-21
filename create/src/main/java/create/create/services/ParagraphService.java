package create.create.services;

import create.create.dtos.ParagraphDTO;
import create.create.dtos.UnitDTO;
import create.create.mappers.ParagraphMapper;
import create.create.models.Paragraph;
import create.create.repositories.ParagraphRepository;
import create.create.services.interfaces.ParagraphProvider;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private UnitService unitService;

    /**
     * Adds a new paragraph.
     *
     * @param paragraph The {@link ParagraphDTO} object representing the paragraph to add.
     * @param unitId    The ID of the unit to which the paragraph will be associated.
     * @return The {@link ParagraphDTO} object that was added.
     * @throws IllegalArgumentException if the provided {@code paragraph} is null.
     */
    @Override
    @Transactional
    public ParagraphDTO create(ParagraphDTO paragraph, int unitId) {
        ParagraphDTO paragraphDTO = paragraphMapper.toDTO(paragraphRepository.save(paragraphMapper.toEntity(paragraph)));
        UnitDTO unitDTO = unitService.findById(unitId);
        unitDTO.getParagraphs().add(paragraphDTO);
        unitService.update(unitDTO);
        return paragraphDTO;
    }

    /**
     * Overridden method to edit a new Paragraph entity based on data provided in the ParagraphDTO.
     * This method performs the save operation of the Paragraph entity to the database.
     *
     * @param paragraphDTO The ParagraphDTO object containing data to create a new Paragraph entity.
     * @return The Paragraph object representing the newly created Paragraph entity after saving it to the database.
     * @throws IllegalArgumentException if no Paragraph exists with the given id.
     */
    @Override
    public ParagraphDTO update(ParagraphDTO paragraphDTO) {
        Paragraph paragraph = paragraphRepository.findById(paragraphDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Paragraph not found id: " + paragraphDTO.getId()));
        Paragraph entity = paragraphMapper.toEntity(paragraphDTO);
        paragraph.setName(entity.getName());
        paragraph.setText(entity.getText());
        paragraph.setQuestions(entity.getQuestions());
        paragraph.setTests(entity.getTests());
        paragraph.setControlWorks(entity.getControlWorks());
        return paragraphMapper.toDTO(paragraphRepository.save(paragraph));
    }

    /**
     * Deletes a Paragraph entity from the database by its identifier.
     *
     * @param id The identifier of the Paragraph to delete.
     * @throws IllegalArgumentException if no Paragraph exists with the given id.
     */
    @Override
    public void delete(int id) {
        if (paragraphRepository.existsById(id))
            paragraphRepository.deleteById(id);
        else
            throw new IllegalArgumentException("Paragraph not found with id: " + id);
    }
}
