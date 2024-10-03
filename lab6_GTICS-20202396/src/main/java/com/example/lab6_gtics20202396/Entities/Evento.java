package com.example.lab6_gtics20202396.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventoid", nullable = false)
    private Integer id;


    @Column(name = "nombre", length = 100)
    @NotBlank(message = "El nombre es obligatorio.")
    @Size(max = 100, min = 3, message = "El nombre debe tener en 3 y 100 caracteres uwu")
    private String nombre;

    @Column(name = "fecha")
    @NotNull(message = "La fecha es obligatoria.")
    @Future(message = "La fecha debe ser en el futuro.")
    private LocalDate fecha;

    @NotNull(message = "El número de asistentes es obligatorio.")
    @Min(value = 1, message = "El número de asistentes debe ser un valor positivo.")
    @Column(name = "asistentesesperados")
    private Integer asistentesEsperados;

}

