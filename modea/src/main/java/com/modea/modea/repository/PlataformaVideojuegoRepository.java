package com.modea.modea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modea.modea.model.PlataformaVideojuego;

@Repository
public interface PlataformaVideojuegoRepository extends JpaRepository<PlataformaVideojuego, Long> {

    List<PlataformaVideojuego> findById(Integer id);
}
