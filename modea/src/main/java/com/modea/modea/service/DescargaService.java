package com.modea.modea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modea.modea.model.Descarga;
import com.modea.modea.repository.DescargaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional


public class DescargaService {

    
    @Autowired
    private DescargaRepository descargaRepository;

    public List<Descarga> findAll(){
        return descargaRepository.findAll();
    }

   public Descarga save(Descarga descarga) {
    return descargaRepository.save(descarga);
    }
    
    public void delete(Long id) {
        descargaRepository.deleteById(id);
    }

    public Descarga findById(Long id) {
        Optional<Descarga> descargaOptional = descargaRepository.findById(id);
        if (descargaOptional.isPresent()) {
            return descargaOptional.get();
        } else {
            throw new RuntimeException("La descarga/archivo no existe");
        }
    }

    public Descarga patchDescarga(Long id, Descarga parcialDescarga){
        Optional<Descarga> descargaOptional = descargaRepository.findById(id);
        if (descargaOptional.isPresent()) {
            
            Descarga descargaToUpdate = descargaOptional.get();
            
            if (parcialDescarga.getNombreDescarga() != null) {
                descargaToUpdate.setNombreDescarga(parcialDescarga.getNombreDescarga());   
            }

            if (parcialDescarga.getTamanoArchivo() != null) {
                descargaToUpdate.setTamanoArchivo(parcialDescarga.getTamanoArchivo());   
            }
            
            if (parcialDescarga.getTipoArchivo() != null) {
                descargaToUpdate.setTipoArchivo(parcialDescarga.getTipoArchivo());   
            }

            return descargaRepository.save(descargaToUpdate);
        } else {
            throw new RuntimeException("La descarga/archivo no existe");
        }
    }

}
