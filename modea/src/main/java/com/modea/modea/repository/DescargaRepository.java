package com.modea.modea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modea.modea.model.Descarga;

@Repository
public interface DescargaRepository extends JpaRepository<Descarga, Long> {

    List<Descarga> findById(Integer id);

}
