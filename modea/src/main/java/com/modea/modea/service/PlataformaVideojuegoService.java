package com.modea.modea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modea.modea.model.PlataformaVideojuego;
import com.modea.modea.repository.PlataformaVideojuegoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlataformaVideojuegoService {

    @Autowired
    private PlataformaVideojuegoRepository plataformaVideojuegoRepository;

    public List<PlataformaVideojuego> findAll(){
        return plataformaVideojuegoRepository.findAll();
    }

   public PlataformaVideojuego save(PlataformaVideojuego plataformaVideojuego) {
    return plataformaVideojuegoRepository.save(plataformaVideojuego);
    }
    
    public void delete(Long id) {
        plataformaVideojuegoRepository.deleteById(id);
    }

    public PlataformaVideojuego findById(Long id) {
        Optional<PlataformaVideojuego> plataformaVideojuegoOptional = plataformaVideojuegoRepository.findById(id);
        if (plataformaVideojuegoOptional.isPresent()) {
            return plataformaVideojuegoOptional.get();
        } else {
            throw new RuntimeException("No existe");
        }
    }

    public PlataformaVideojuego patchPlataformaVideojuego(Long id, PlataformaVideojuego parcialPlataformaVideojuego){
        Optional<PlataformaVideojuego> plataformaVideojuegoOptional = plataformaVideojuegoRepository.findById(id);
        if (plataformaVideojuegoOptional.isPresent()) {
            
            PlataformaVideojuego plataformaVideojuegoToUpdate = plataformaVideojuegoOptional.get();
            
            if (parcialPlataformaVideojuego.getPlataforma() != null) {
                plataformaVideojuegoToUpdate.setPlataforma(parcialPlataformaVideojuego.getPlataforma());   
            }

            if(parcialPlataformaVideojuego.getVideojuego() != null) {
                plataformaVideojuegoToUpdate.setVideojuego(parcialPlataformaVideojuego.getVideojuego());
            }

            return plataformaVideojuegoRepository.save(plataformaVideojuegoToUpdate);
        } else {
            throw new RuntimeException("No se encuentra");
        }
    }

}
