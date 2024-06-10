package org.luismore.hlvs.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EntryDTO {
    @NotBlank
    private String type;

    private String resident;

    private String vehicle;

    @NotNull
    private String entryTime;

    private String comment;

    private String headline;
}
