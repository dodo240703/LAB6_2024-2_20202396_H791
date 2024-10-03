package com.example.lab6_gtics20202396.Repositories;

import com.example.lab6_gtics20202396.Entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

}
