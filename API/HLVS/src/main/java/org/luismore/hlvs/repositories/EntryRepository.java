package org.luismore.hlvs.repositories;

import org.luismore.hlvs.domain.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
