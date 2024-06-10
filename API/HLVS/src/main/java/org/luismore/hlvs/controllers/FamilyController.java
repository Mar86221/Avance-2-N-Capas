package org.luismore.hlvs.controllers;

import org.luismore.hlvs.domain.dtos.FamilyMemberDTO;
import org.luismore.hlvs.domain.entities.FamilyMember;
import org.luismore.hlvs.domain.dtos.GeneralResponse;
import org.luismore.hlvs.services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/family")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @GetMapping("/members")
    public ResponseEntity<GeneralResponse> getFamilyMembers(@RequestParam Long userId) {
        List<FamilyMember> familyMembers = familyService.getFamilyMembers(userId);
        return GeneralResponse.getResponse(familyMembers, "Family members fetched successfully");
    }

    @PostMapping("/add")
    public ResponseEntity<GeneralResponse> addFamilyMember(@RequestParam Long userId, @RequestBody FamilyMemberDTO familyMemberDto) {
        FamilyMember addedMember = familyService.addFamilyMember(userId, familyMemberDto);
        return GeneralResponse.getResponse(addedMember, "Family member added successfully");
    }
}
