package org.luismore.hlvs.services.impls;

import org.luismore.hlvs.domain.dtos.EntryDTO;
import org.luismore.hlvs.domain.entities.Entry;
import org.luismore.hlvs.repositories.EntryRepository;
import org.luismore.hlvs.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepository;

    @Override
    public Entry registerEntry(EntryDTO entryDto) {
        Entry entry = new Entry();
        entry.setType(entryDto.getType());
        entry.setResident(entryDto.getResident());
        entry.setVehicle(entryDto.getVehicle());
        entry.setEntryTime(entryDto.getEntryTime());
        entry.setComment(entryDto.getComment());
        entry.setHeadline(entryDto.getHeadline());
        return entryRepository.save(entry);
    }

    @Override
    public Entry registerAnonymousEntry(EntryDTO entryDto) {
        Entry entry = new Entry();
        entry.setType("Anonymous");
        entry.setComment(entryDto.getComment());
        entry.setHeadline(entryDto.getHeadline());
        return entryRepository.save(entry);
    }

    @Override
    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }
}
