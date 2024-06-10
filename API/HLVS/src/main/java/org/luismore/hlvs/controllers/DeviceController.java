package org.luismore.hlvs.controllers;

import org.luismore.hlvs.domain.dtos.DeviceDTO;
import org.luismore.hlvs.domain.entities.Device;
import org.luismore.hlvs.domain.dtos.GeneralResponse;
import org.luismore.hlvs.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public ResponseEntity<GeneralResponse> getAllDevices() {
        List<Device> devices = deviceService.getAllDevices();
        return GeneralResponse.getResponse(devices, "Devices fetched successfully");
    }

    @PostMapping("/createDevice")
    public ResponseEntity<GeneralResponse> createDevice(@RequestBody DeviceDTO device) {
        Device createdDevice = deviceService.createDevice(device);
        return GeneralResponse.getResponse(createdDevice, "Device created successfully");
    }

    @PostMapping("/{deviceId}")
    public ResponseEntity<GeneralResponse> updateDevice(@PathVariable Long deviceId, @RequestBody DeviceDTO device) {
        Device updatedDevice = deviceService.updateDevice(deviceId, device);
        return GeneralResponse.getResponse(updatedDevice, "Device updated successfully");
    }
}