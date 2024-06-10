package org.luismore.hlvs.repositories;

import org.luismore.hlvs.domain.entities.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
    List<Resident> findByHouseId(Long houseId);
}
