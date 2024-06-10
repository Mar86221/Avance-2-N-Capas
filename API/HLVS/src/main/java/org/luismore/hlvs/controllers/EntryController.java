package org.luismore.hlvs.controllers;

import org.luismore.hlvs.domain.dtos.EntryDTO;
import org.luismore.hlvs.domain.dtos.GeneralResponse;
import org.luismore.hlvs.domain.entities.Entry;
import org.luismore.hlvs.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entries")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @PostMapping("/")
    public ResponseEntity<GeneralResponse> registerEntry(@RequestBody EntryDTO entry) {
        Entry registeredEntry = entryService.registerEntry(entry);
        return GeneralResponse.getResponse(registeredEntry, "Entry registered successfully");
    }

    @PostMapping("/anonymous")
    public ResponseEntity<GeneralResponse> registerAnonymousEntry(@RequestBody EntryDTO entry) {
        Entry registeredEntry = entryService.registerAnonymousEntry(entry);
        return GeneralResponse.getResponse(registeredEntry, "Anonymous entry registered successfully");
    }

    @GetMapping("/")
    public ResponseEntity<GeneralResponse> getAllEntries() {
        List<Entry> entries = entryService.getAllEntries();
        return GeneralResponse.getResponse(entries, "Entries fetched successfully");
    }
}
