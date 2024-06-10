package org.luismore.hlvs.services;

import org.luismore.hlvs.domain.dtos.HouseDTO;
import org.luismore.hlvs.domain.entities.House;
import org.luismore.hlvs.domain.entities.Resident;

import java.util.List;

public interface HouseService {
    List<House> listAllHouses();
    House createHouse(HouseDTO houseDto);
    List<Resident> createResidents(Long houseId, List<Resident> residents);
    House updateHouse(Long houseId, HouseDTO houseDto);
    List<Resident> updateResidents(Long houseId, List<Resident> residents);
    List<Resident> listResidentsByHouseId(Long houseId);
}
