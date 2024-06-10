package org.luismore.hlvs.repositories;

import org.luismore.hlvs.domain.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
}
