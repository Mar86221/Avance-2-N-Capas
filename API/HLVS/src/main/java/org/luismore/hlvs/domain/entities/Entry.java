package org.luismore.hlvs.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "entries")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String resident;

    private String vehicle;

    private String entryTime;

    private String comment;

    private String headline;
}
