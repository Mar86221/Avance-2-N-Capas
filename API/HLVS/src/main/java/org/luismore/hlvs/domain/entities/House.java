package org.luismore.hlvs.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "houses")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String houseNumber;

    private String address;

    private Integer residentNumber;

    private Integer residentLimit;

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY)
    private List<Resident> residents;
}
