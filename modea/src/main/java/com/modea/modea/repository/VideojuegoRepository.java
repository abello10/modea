package com.modea.modea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modea.modea.model.Videojuego;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {

    List<Videojuego> findById(Integer id);
    
    List<Videojuego> findByNombreVideojuego(String nombreVideojuego);

    List<Videojuego> findByGenero(String genero);



}
