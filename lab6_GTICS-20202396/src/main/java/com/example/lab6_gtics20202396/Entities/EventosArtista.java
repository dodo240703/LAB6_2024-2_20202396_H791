package com.example.lab6_gtics20202396.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "eventos_artistas")
public class EventosArtista {
    @EmbeddedId
    private EventosArtistaId id;

    @MapsId("eventoId")
    @ManyToOne
    @JoinColumn(name = "eventoid", nullable = false)
    private Evento evento;

    @MapsId("artistaId")
    @ManyToOne
    @JoinColumn(name = "artistaid", nullable = false)
    private Artista artista;

}