package create.create.services;

import create.create.dtos.UnitDTO;
import create.create.mappers.UnitMapper;
import create.create.models.Unit;
import create.create.repositories.UnitRepository;
import create.create.services.interfaces.Mapper;
import create.create.services.interfaces.UnitProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class implementing the UnitProvider interface and Mapper for UnitDTO and Unit entities.
 */
@Service
public class UnitService implements UnitProvider, Mapper<UnitDTO, Unit> {
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
    public UnitDTO add(UnitDTO unitDTO) throws IllegalArgumentException {
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
    public UnitDTO edit(UnitDTO unitDTO) throws IllegalArgumentException {
        if (!unitRepository.existsById(unitDTO.getId()))
            throw new IllegalArgumentException("Unit with id " + unitDTO.getId() + " does not exist");

        return unitMapper.toDTO(unitRepository.save(unitMapper.toEntity(unitDTO)));
    }

    /**
     * Deletes a Unit entity from the database by its identifier.
     *
     * @param id The identifier of the Unit to delete.
     * @throws IllegalArgumentException if no Unit exists with the given id.
     */
    @Override
    public void remove(int id) throws IllegalArgumentException {
        if (unitRepository.existsById(id))
            unitRepository.deleteById(id);
        else
            throw new IllegalArgumentException("Unit not found with id: " + id);
    }

    /**
     * Converts a Unit entity to a UnitDTO using the UnitMapper.
     *
     * @param unit The Unit entity to convert.
     * @return The corresponding UnitDTO.
     */
    @Override
    public UnitDTO toDTO(Unit unit) {
        return unitMapper.toDTO(unit);
    }

    /**
     * Converts a list of Unit entities to a list of UnitDTOs using the UnitMapper.
     *
     * @param list The list of Unit entities to convert.
     * @return The list of corresponding UnitDTOs.
     */
    @Override
    public List<UnitDTO> listToDTO(List<Unit> list) {
        return unitMapper.listToDTO(list);
    }

    /**
     * Converts a UnitDTO entity to a Unit using the UnitMapper.
     *
     * @param unitDTO The UnitDTO entity to convert.
     * @return The corresponding Unit.
     */
    @Override
    public Unit toEntity(UnitDTO unitDTO) {
        return unitMapper.toEntity(unitDTO);
    }

    /**
     * Converts a list of UnitDTO entities to a list of Unit using the UnitMapper.
     *
     * @param list The list of UnitDTO entities to convert.
     * @return The list of corresponding Unit.
     */
    @Override
    public List<Unit> listToEntity(List<UnitDTO> list) {
        return unitMapper.listToEntity(list);
    }
}
