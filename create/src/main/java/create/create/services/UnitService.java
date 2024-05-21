package create.create.services;

import create.create.dtos.UnitDTO;
import create.create.mappers.UnitMapper;
import create.create.models.Unit;
import create.create.repositories.UnitRepository;
import create.create.services.interfaces.UnitProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class implementing the UnitProvider interface.
 */
@Service
public class UnitService implements UnitProvider {
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private UnitMapper unitMapper;

    /**
     * Overridden method to add a new Unit entity based on data provided in the UnitDTO.
     * This method performs the save operation of the Unit entity to the database.
     *
     * @param unitDTO The UnitDTO object containing data to create a new Unit entity.
     * @return The Unit object representing the newly created Unit entity after saving it to the database.
     * @throws IllegalArgumentException if no Unit exists with the given name.
     */
    @Override
    public UnitDTO create(UnitDTO unitDTO) throws IllegalArgumentException {
        if (unitRepository.existsByName(unitDTO.getName()))
            throw new IllegalArgumentException("Unit with the same name already exists: " + unitDTO.getName());

        return unitMapper.toDTO(unitRepository.save(unitMapper.toEntity(unitDTO)));
    }

    /**
     * Overridden method to edit a new Unit entity based on data provided in the UnitDTO.
     * This method performs the save operation of the Unit entity to the database.
     *
     * @param unitDTO The UnitDTO object containing data to create a new Unit entity.
     * @return The Unit object representing the newly created Unit entity after saving it to the database.
     * @throws IllegalArgumentException if no Unit exists with the given id.
     */
    @Override
    public UnitDTO update(UnitDTO unitDTO) throws IllegalArgumentException {
        Unit unit = unitRepository.findById(unitDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Unit not found id: " + unitDTO.getId()));
        Unit entity = unitMapper.toEntity(unitDTO);
        unit.setName(entity.getName());
        unit.setSubject(entity.getSubject());
        unit.setClassEntity(entity.getClassEntity());
        unit.setTest(entity.getTest());
        unit.setControlWork(entity.getControlWork());
        unit.setParagraphs(entity.getParagraphs());
        return unitMapper.toDTO(unitRepository.save(unit));
    }

    /**
     * Deletes a Unit entity from the database by its identifier.
     *
     * @param id The identifier of the Unit to delete.
     * @throws IllegalArgumentException if no Unit exists with the given id.
     */
    @Override
    public void delete(int id) throws IllegalArgumentException {
        if (unitRepository.existsById(id))
            unitRepository.deleteById(id);
        else
            throw new IllegalArgumentException("Unit not found with id: " + id);
    }

    /**
     * Retrieves a UnitDTO object by its ID.
     *
     * @param id The ID of the unit to retrieve.
     * @return The UnitDTO object corresponding to the specified ID.
     * @throws RuntimeException if the unit with the given ID is not found.
     */
    @Override
    public UnitDTO findById(int id) throws RuntimeException {
        return unitMapper.toDTO(unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit not found with id: " + id)));
    }
}
