package org.luismore.hlvs.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DeviceDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String deviceType;
}
