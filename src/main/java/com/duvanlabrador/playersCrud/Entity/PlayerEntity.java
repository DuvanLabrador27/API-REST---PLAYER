package com.duvanlabrador.playersCrud.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "player")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "number_shirt", nullable = false)
    private String numberShirt;
    @Column(name = "position", nullable = false)
    private String position;
    @Column(name = "date", nullable = false)
    private LocalDate date;

}
