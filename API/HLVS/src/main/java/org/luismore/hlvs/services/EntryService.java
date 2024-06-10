package org.luismore.hlvs.services;

import org.luismore.hlvs.domain.dtos.EntryDTO;
import org.luismore.hlvs.domain.entities.Entry;

import java.util.List;

public interface EntryService {
    Entry registerEntry(EntryDTO entryDto);
    Entry registerAnonymousEntry(EntryDTO entryDto);
    List<Entry> getAllEntries();
}
