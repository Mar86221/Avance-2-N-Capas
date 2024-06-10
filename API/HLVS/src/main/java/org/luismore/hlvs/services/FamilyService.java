package org.luismore.hlvs.services;

import org.luismore.hlvs.domain.dtos.FamilyMemberDTO;
import org.luismore.hlvs.domain.entities.FamilyMember;

import java.util.List;

public interface FamilyService {
    List<FamilyMember> getFamilyMembers(Long userId);
    FamilyMember addFamilyMember(Long userId, FamilyMemberDTO familyMemberDto);
}
