package org.luismore.hlvs.domain.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FamilyMemberDTO {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;
}
