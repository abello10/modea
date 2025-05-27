package com.modea.modea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modea.modea.model.Mod;
import com.modea.modea.repository.ModRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ModService {

    @Autowired
    private ModRepository modRepository;

    public List<Mod> findAll(){
        return modRepository.findAll();
    }

   public Mod save(Mod mod) {
    return modRepository.save(mod);
    }

    public void delete(Long id) {
        modRepository.deleteById(id);
    }

    public Mod findById(Long id) {
        Optional<Mod> modOptional = modRepository.findById(id);
        if (modOptional.isPresent()) {
            return modOptional.get();
        } else {
            throw new RuntimeException("El mod que buscas no existe :P");
        }
    }

    public Mod patchMod(Long id, Mod parcialMod){
        Optional<Mod> modOptional = modRepository.findById(id);
        if (modOptional.isPresent()) {
            
            Mod modToUpdate = modOptional.get();
            
            if (parcialMod.getCategoriamod() != null) {
                modToUpdate.setCategoriamod(parcialMod.getCategoriamod());   
            }
            if (parcialMod.getDescarga() != null) {
                modToUpdate.setDescarga(parcialMod.getDescarga());   
            }
            if (parcialMod.getDescripcionMod() != null) {
                modToUpdate.setDescripcionMod(parcialMod.getDescripcionMod());   
            }
            if (parcialMod.getFecha() != null) {
                modToUpdate.setFecha(parcialMod.getFecha());   
            }
            if (parcialMod.getFeedback() != null) {
                modToUpdate.setFeedback(parcialMod.getFeedback());   
            }
            if (parcialMod.getNombreMod() != null) {
                modToUpdate.setNombreMod(parcialMod.getNombreMod());   
            }
            if (parcialMod.getPlataforma() != null) {
                modToUpdate.setPlataforma(parcialMod.getPlataforma());   
            }
            if (parcialMod.getUsuario() != null) {
                modToUpdate.setUsuario(parcialMod.getUsuario());   
            }
            if (parcialMod.getVersion() != null) {
                modToUpdate.setVersion(parcialMod.getVersion());   
            }
            if (parcialMod.getVideojuego() != null) {
                modToUpdate.setVideojuego(parcialMod.getVideojuego());   
            }

            return modRepository.save(modToUpdate);
        } else {
            throw new RuntimeException("El mod no existe");
        }
    }


}
