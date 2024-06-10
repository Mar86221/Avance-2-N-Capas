package org.luismore.hlvs.services;

import org.luismore.hlvs.domain.dtos.DeviceDTO;
import org.luismore.hlvs.domain.entities.Device;

import java.util.List;

public interface DeviceService {
    List<Device> getAllDevices();

    List<Device> listAllDevices();

    Device createDevice(DeviceDTO deviceDto);
    Device updateDevice(Long deviceId, DeviceDTO deviceDto);
}

