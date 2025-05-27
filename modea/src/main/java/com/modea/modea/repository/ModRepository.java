package com.modea.modea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modea.modea.model.Mod;

@Repository
public interface ModRepository extends JpaRepository<Mod, Long> {

    List<Mod> findByNombreMod(String nombreMod);
    
    List<Mod> findById(Integer id);
}
