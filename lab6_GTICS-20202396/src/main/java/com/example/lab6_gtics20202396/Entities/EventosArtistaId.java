package com.example.lab6_gtics20202396.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class EventosArtistaId implements java.io.Serializable {
    private static final long serialVersionUID = -2483600232949999846L;
    @Column(name = "eventoid", nullable = false)
    private Integer eventoId;

    @Column(name = "artistaid", nullable = false)
    private Integer artistaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EventosArtistaId entity = (EventosArtistaId) o;
        return Objects.equals(this.eventoId, entity.eventoId) &&
                Objects.equals(this.artistaId, entity.artistaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventoId, artistaId);
    }

}