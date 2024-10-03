package com.example.lab6_gtics20202396.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artistaid", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "genero", length = 50)
    private String genero;

    @Column(name = "telefono", length = 9)
    private String telefono;

}