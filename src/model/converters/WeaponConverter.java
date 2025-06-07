package model.converters;

import model.dto.WeaponDTO;
import model.entities.weapons.Weapon;
import model.entities.weapons.WeaponFactory;

public class WeaponConverter extends Converter<Weapon, WeaponDTO> {

    @Override
    public WeaponDTO fromEntityToDTO(Weapon entity) {
        if (entity == null)
            return null;

        WeaponDTO dto = new WeaponDTO();
        dto.setCost(entity.getCost());
        dto.setType(entity.getClass().getSimpleName());
        return dto;
    }

    @Override
    public Weapon fromDTOtoEntity(WeaponDTO dto) {
        if (dto == null)
            return null;

        return WeaponFactory.newWeapon(dto.getType());
    }

}
