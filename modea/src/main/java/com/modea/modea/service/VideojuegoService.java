package com.modea.modea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modea.modea.model.Videojuego;
import com.modea.modea.repository.VideojuegoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VideojuegoService {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    public List<Videojuego> findAll(){
        return videojuegoRepository.findAll();
    }

   public Videojuego save(Videojuego videojuego) {
    return videojuegoRepository.save(videojuego);
    }

    public void delete(Long id) {
        videojuegoRepository.deleteById(id);
    }

    public Videojuego findById(Long id) {
        Optional<Videojuego> videojuegoOptional = videojuegoRepository.findById(id);
        if (videojuegoOptional.isPresent()) {
            return videojuegoOptional.get();
        } else {
            throw new RuntimeException("No existe el videojuego");
        }
    }

    public Videojuego patchVideojuego(Long id, Videojuego parcialVideojuego){
        Optional<Videojuego> videojuegoOptional = videojuegoRepository.findById(id);
        if (videojuegoOptional.isPresent()) {
            
            Videojuego videojuegoToUpdate = videojuegoOptional.get();
            
            if (parcialVideojuego.getNombreVideojuego() != null) {
                videojuegoToUpdate.setNombreVideojuego(parcialVideojuego.getNombreVideojuego());   
            }

            if(parcialVideojuego.getGenero() != null) {
                videojuegoToUpdate.setGenero(parcialVideojuego.getGenero());
            }

            if(parcialVideojuego.getDescripcionVideojuego() != null) {
                videojuegoToUpdate.setDescripcionVideojuego(parcialVideojuego.getDescripcionVideojuego());
            }

            if(parcialVideojuego.getPortada() != null) {
                videojuegoToUpdate.setPortada(parcialVideojuego.getPortada());
            }

            return videojuegoRepository.save(videojuegoToUpdate);
        } else {
            throw new RuntimeException("Videojuego no existe");
        }
    }



}
