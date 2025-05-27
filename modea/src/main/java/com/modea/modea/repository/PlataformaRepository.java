package com.modea.modea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modea.modea.model.Plataforma;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Long> {

    List<Plataforma> findById(Integer id);

}
