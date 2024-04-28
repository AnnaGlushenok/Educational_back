package education.education.services.interfaces;

import education.education.dtos.ParagraphDTO;

/**
 * This interface extends the DataProvider interface for retrieving ParagraphDTO objects.
 */
public interface ParagraphProvider extends DataProvider<ParagraphDTO> {
    /**
     * Retrieves a ParagraphDTO object by its ID.
     *
     * @param id The ID of the paragraph to retrieve.
     * @return The ParagraphDTO object corresponding to the specified ID.
     */
    ParagraphDTO findById(int id);
}
