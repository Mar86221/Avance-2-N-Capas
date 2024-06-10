package org.luismore.hlvs.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestDTO {
    @NotBlank
    private String dui;

    @NotNull
    private Long homeId;

    @NotBlank
    private String entryDate;

    @NotBlank
    private String entryTime;

    @NotBlank
    private String state;
}
