package create.create.services.interfaces;

import create.create.dtos.UnitDTO;

/**
 * The UnitProvider interface extends the DataProvider interface to provide methods specific to managing UnitDTO objects.
 * It also includes additional methods for retrieving classes and subjects related to units.
 */
public interface UnitProvider extends DataProvider<UnitDTO> {
    /**
     * Adds a new UnitDTO entity based on data provided in the UnitDTO.
     *
     * @param unitDTO The UnitDTO object containing data to create a new UnitDTO entity.
     * @return The UnitDTO object representing the newly created Unit entity after saving it to the database.
     */
    UnitDTO add(UnitDTO unitDTO);

    /**
     * Update a new UnitDTO entity based on data provided in the UnitDTO.
     *
     * @param unitDTO The UnitDTO object containing data to update a new UnitDTO entity.
     * @return The UnitDTO object representing the newly Unit entity after saving it to the database.
     */
    UnitDTO edit(UnitDTO unitDTO);

    /**
     * Removes an item with the specified ID from the collection.
     *
     * @param id The unique identifier of the item to be removed.
     * @throws IllegalArgumentException if the specified ID is invalid or not found in the collection.
     */
    void remove(int id);
}
