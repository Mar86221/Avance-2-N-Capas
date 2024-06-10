package org.luismore.hlvs.repositories;

import org.luismore.hlvs.domain.entities.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {
    List<FamilyMember> findByHouseId(Long houseId);
}
