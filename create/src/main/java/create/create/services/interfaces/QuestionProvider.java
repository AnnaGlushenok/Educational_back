package create.create.services.interfaces;

import create.create.dtos.QuestionDTO;

/**
 * The QuestionProvider interface extends the DataProvider interface to provide methods specific to managing QuestionDTO objects.
 */
public interface QuestionProvider extends DataProvider<QuestionDTO> {
    /**
     * Adds a new QuestionDTO entity based on data provided in the QuestionDTO.
     *
     * @param questionDTO The QuestionDTO object containing data to create a new QuestionDTO entity.
     * @return The QuestionDTO object representing the newly created Question entity after saving it to the database.
     */
    QuestionDTO create(QuestionDTO questionDTO);

    /**
     * Update a new QuestionDTO entity based on data provided in the QuestionDTO.
     *
     * @param questionDTO The QuestionDTO object containing data to update a new QuestionDTO entity.
     * @return The QuestionDTO object representing the new Question entity after saving it to the database.
     */
    QuestionDTO update(QuestionDTO questionDTO);

    /**
     * Removes an item with the specified ID from the collection.
     *
     * @param id The unique identifier of the item to be removed.
     * @throws IllegalArgumentException if the specified ID is invalid or not found in the collection.
     */
    void delete(int id);

    /**
     * Retrieves a QuestionDTO object by its ID.
     *
     * @param id The ID of the paragraph to retrieve.
     * @return The QuestionDTO object corresponding to the specified ID.
     */
    QuestionDTO findById(int id);
}
