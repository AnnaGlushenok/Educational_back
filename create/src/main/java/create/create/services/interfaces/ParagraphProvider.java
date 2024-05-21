package create.create.services.interfaces;

import create.create.dtos.ParagraphDTO;

/**
 * This interface extends the DataProvider interface for retrieving ParagraphDTO objects.
 */
public interface ParagraphProvider extends DataProvider<ParagraphDTO> {
    /**
     * Creates a new paragraph and associates it with a specified unit.
     *
     * @param paragraph The {@link ParagraphDTO} object representing the paragraph to create.
     * @param unitId The ID of the unit to which the paragraph will be associated.
     * @return The {@link ParagraphDTO} object representing the created paragraph.
     * @throws IllegalArgumentException if the provided {@code paragraph} is {@code null} or if {@code unitId} is not valid.
     */
    ParagraphDTO create(ParagraphDTO paragraph, int unitId);

    /**
     * Update a new ParagraphDTO entity based on data provided in the ParagraphDTO.
     *
     * @param paragraphDTO The ParagraphDTO object containing data to update a new ParagraphDTO entity.
     * @return The ParagraphDTO object representing the new Paragraph entity after saving it to the database.
     */
    ParagraphDTO update(ParagraphDTO paragraphDTO);

    /**
     * Removes an item with the specified ID from the collection.
     *
     * @param id The unique identifier of the item to be removed.
     * @throws IllegalArgumentException if the specified ID is invalid or not found in the collection.
     */
    void delete(int id);
}
