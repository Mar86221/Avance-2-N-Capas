package org.luismore.hlvs.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HouseDTO {
    @NotBlank
    private String houseNumber;

    @NotBlank
    private String address;

    @NotNull
    private Integer residentNumber;

    @NotNull
    private Integer residentLimit;
}
