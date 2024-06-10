package org.luismore.hlvs.services.impls;

import org.luismore.hlvs.domain.dtos.FamilyMemberDTO;
import org.luismore.hlvs.domain.entities.FamilyMember;
import org.luismore.hlvs.domain.entities.User;
import org.luismore.hlvs.exceptions.ResourceNotFoundException;
import org.luismore.hlvs.exceptions.UnauthorizedException;
import org.luismore.hlvs.repositories.FamilyMemberRepository;
import org.luismore.hlvs.repositories.UserRepository;
import org.luismore.hlvs.services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<FamilyMember> getFamilyMembers(Long userId) {
        User mainResident = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Can(not) found"));
        return familyMemberRepository.findByHouseId(mainResident.getHouse().getId());
    }

    @Override
    public FamilyMember addFamilyMember(Long userId, FamilyMemberDTO familyMemberDto) {
        User mainResident = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Can(not) found"));
        if (mainResident.getRole().equals("Main Resident") && mainResident.getHouse().getResidents().size() < mainResident.getHouse().getResidentLimit()) {
            FamilyMember familyMember = new FamilyMember();
            familyMember.setName(familyMemberDto.getName());
            familyMember.setEmail(familyMemberDto.getEmail());
            familyMember.setHouse(mainResident.getHouse());
            return familyMemberRepository.save(familyMember);
        } else {
            throw new UnauthorizedException("You do not have permission to add a family member or the limit has been reached");
        }
    }
}

