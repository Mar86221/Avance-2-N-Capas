package org.luismore.hlvs.services.impls;

import org.luismore.hlvs.domain.dtos.HouseDTO;
import org.luismore.hlvs.domain.entities.House;
import org.luismore.hlvs.domain.entities.Resident;
import org.luismore.hlvs.exceptions.ResourceNotFoundException;
import org.luismore.hlvs.exceptions.UnauthorizedException;
import org.luismore.hlvs.repositories.HouseRepository;
import org.luismore.hlvs.repositories.ResidentRepository;
import org.luismore.hlvs.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private ResidentRepository residentRepository;

    @Override
    public List<House> listAllHouses() {
        return houseRepository.findAll();
    }

    @Override
    public House createHouse(HouseDTO houseDto) {
        House house = new House();
        house.setHouseNumber(houseDto.getHouseNumber());
        house.setAddress(houseDto.getAddress());
        house.setResidentNumber(houseDto.getResidentNumber());
        house.setResidentLimit(houseDto.getResidentLimit());
        return houseRepository.save(house);
    }

    @Override
    public List<Resident> createResidents(Long houseId, List<Resident> residents) {
        House house = houseRepository.findById(houseId).orElseThrow(() -> new ResourceNotFoundException("House not found")); //DA ERROR EL ResourceNotFoundException
        if (house.getResidents().size() + residents.size() > house.getResidentLimit()) {
            throw new UnauthorizedException("You Can(not) add residents. The limit is reached.");
        }
        for (Resident resident : residents) {
            resident.setHouse(house);
            residentRepository.save(resident);
        }
        return residentRepository.findByHouseId(houseId);
    }

    @Override
    public House updateHouse(Long houseId, HouseDTO houseDto) {
        House house = houseRepository.findById(houseId).orElseThrow(() -> new ResourceNotFoundException("House Can(not) be not found"));
        house.setHouseNumber(houseDto.getHouseNumber());
        house.setAddress(houseDto.getAddress());
        house.setResidentNumber(houseDto.getResidentNumber());
        house.setResidentLimit(houseDto.getResidentLimit());
        return houseRepository.save(house);
    }

    @Override
    public List<Resident> updateResidents(Long houseId, List<Resident> residents) {
        House house = houseRepository.findById(houseId).orElseThrow(() -> new ResourceNotFoundException("House Can(not) be found"));
        for (Resident resident : residents) {
            Resident existingResident = residentRepository.findById(resident.getId()).orElseThrow(() -> new ResourceNotFoundException("Resident not found"));
            existingResident.setName(resident.getName());
            existingResident.setRole(resident.getRole());
            residentRepository.save(existingResident);
        }
        return residentRepository.findByHouseId(houseId);
    }

    @Override
    public List<Resident> listResidentsByHouseId(Long houseId) {
        return residentRepository.findByHouseId(houseId);
    }
}
