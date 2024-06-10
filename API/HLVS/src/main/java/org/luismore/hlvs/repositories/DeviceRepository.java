package org.luismore.hlvs.repositories;

import org.luismore.hlvs.domain.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
