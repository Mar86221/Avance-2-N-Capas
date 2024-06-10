package org.luismore.hlvs.repositories;

import jakarta.transaction.Transactional;
import org.luismore.hlvs.domain.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByHomeIdAndState(Long homeId, String state);

    @Modifying
    @Transactional
    @Query("UPDATE QrDuration q SET q.duration = ?1")
    void updateQrDuration(@Param("newDuration") Long newDuration);
}
