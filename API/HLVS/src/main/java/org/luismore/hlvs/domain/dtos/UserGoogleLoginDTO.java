package org.luismore.hlvs.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserGoogleLoginDTO {
    @NotBlank
    private String idToken;
}

