package com.modea.modea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modea.modea.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
   
    List<Usuario> findById(Integer id);

    List<Usuario> findByCorreo(String correo);

}
