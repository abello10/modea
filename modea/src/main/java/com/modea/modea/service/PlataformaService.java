package com.modea.modea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modea.modea.model.Plataforma;
import com.modea.modea.repository.PlataformaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlataformaService {

    @Autowired
    private PlataformaRepository plataformaRepository;

    public List<Plataforma> findAll(){
        return plataformaRepository.findAll();
    }

   public Plataforma save(Plataforma plataforma) {
    return plataformaRepository.save(plataforma);
    }

    public void delete(Long id) {
        plataformaRepository.deleteById(id);
    }

    public Plataforma findById(Long id) {
        Optional<Plataforma> plataformaOptional = plataformaRepository.findById(id);
        if (plataformaOptional.isPresent()) {
            return plataformaOptional.get();
        } else {
            throw new RuntimeException("La plataforma no existe");
        }
    }

    public Plataforma patchPlataforma(Long id, Plataforma parcialPlataforma){
        Optional<Plataforma> plataformaOptional = plataformaRepository.findById(id);
        if (plataformaOptional.isPresent()) {
            
            Plataforma plataformaToUpdate = plataformaOptional.get();
            
            if (parcialPlataforma.getNombrePlataforma() != null) {
                plataformaToUpdate.setNombrePlataforma(parcialPlataforma.getNombrePlataforma());   
            }

            return plataformaRepository.save(plataformaToUpdate);
        } else {
            throw new RuntimeException("No existe la plataforma");
        }
    }


}
