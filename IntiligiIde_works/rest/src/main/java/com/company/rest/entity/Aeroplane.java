package com.company.rest.entity;

import com.company.rest.util.AeroplaneStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aeroplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String manufacturer;
    private int capacity;

    @Enumerated(EnumType.STRING)
    private AeroplaneStatus status;

}