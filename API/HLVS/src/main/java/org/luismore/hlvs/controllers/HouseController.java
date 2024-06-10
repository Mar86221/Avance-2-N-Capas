package org.luismore.hlvs.controllers;

import org.luismore.hlvs.domain.dtos.HouseDTO;
import org.luismore.hlvs.domain.dtos.GeneralResponse;
import org.luismore.hlvs.domain.entities.House;
import org.luismore.hlvs.domain.entities.Resident;
import org.luismore.hlvs.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/houses")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/")
    public ResponseEntity<GeneralResponse> getAllHouses() {
        List<House> houses = houseService.listAllHouses();
        return GeneralResponse.getResponse(houses, "Houses fetched successfully");
    }

    @PostMapping("/")
    public ResponseEntity<GeneralResponse> createHouse(@RequestBody HouseDTO houseDto) {
        House createdHouse = houseService.createHouse(houseDto);
        return GeneralResponse.getResponse(createdHouse, "House created successfully");
    }

    @PostMapping("/{houseId}/residents")
    public ResponseEntity<GeneralResponse> createResidents(@PathVariable Long houseId, @RequestBody List<Resident> residents) {
        List<Resident> createdResidents = houseService.createResidents(houseId, residents);
        return GeneralResponse.getResponse(createdResidents, "Residents created successfully");
    }

    @PutMapping("/{houseId}")
    public ResponseEntity<GeneralResponse> updateHouse(@PathVariable Long houseId, @RequestBody HouseDTO houseDto) {
        House updatedHouse = houseService.updateHouse(houseId, houseDto);
        return GeneralResponse.getResponse(updatedHouse, "House updated successfully");
    }

    @PutMapping("/{houseId}/residents")
    public ResponseEntity<GeneralResponse> updateResidents(@PathVariable Long houseId, @RequestBody List<Resident> residents) {
        List<Resident> updatedResidents = houseService.updateResidents(houseId, residents);
        return GeneralResponse.getResponse(updatedResidents, "Residents updated successfully");
    }

    @GetMapping("/{houseId}/residents")
    public ResponseEntity<GeneralResponse> getResidentsByHouseId(@PathVariable Long houseId) {
        List<Resident> residents = houseService.listResidentsByHouseId(houseId);
        return GeneralResponse.getResponse(residents, "Residents fetched successfully");
    }
}
