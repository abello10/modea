package com.modea.modea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modea.modea.model.CategoriaMod;

@Repository
public interface CategoriaModRepository extends JpaRepository<CategoriaMod, Long> {

    List<CategoriaMod> findByNombreCategoria(String nombreCategoria);
    List<CategoriaMod> findById(Integer id);
}
