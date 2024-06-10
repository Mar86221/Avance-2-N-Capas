package org.luismore.hlvs.services.impls;

import org.luismore.hlvs.domain.dtos.DeviceDTO;
import org.luismore.hlvs.domain.entities.Device;
import org.luismore.hlvs.exceptions.ResourceNotFoundException;
import org.luismore.hlvs.repositories.DeviceRepository;
import org.luismore.hlvs.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public List<Device> listAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device createDevice(DeviceDTO deviceDto) {
        Device device = new Device();
        device.setName(deviceDto.getName());
        device.setType(deviceDto.getDeviceType());
        return deviceRepository.save(device);
    }

    @Override
    public Device updateDevice(Long deviceId, DeviceDTO deviceDto) {
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new ResourceNotFoundException("Device Can(not) be found"));
        device.setName(deviceDto.getName());
        device.setType(deviceDto.getDeviceType());
        return deviceRepository.save(device);
    }
}


