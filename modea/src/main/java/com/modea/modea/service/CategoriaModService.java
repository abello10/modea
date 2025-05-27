package com.modea.modea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modea.modea.model.CategoriaMod;
import com.modea.modea.repository.CategoriaModRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class CategoriaModService {

    @Autowired
    private CategoriaModRepository categoriaModRepository;

    public List<CategoriaMod> findAll(){
        return categoriaModRepository.findAll();
    }

   public CategoriaMod save(CategoriaMod categoriaMod) {
    return categoriaModRepository.save(categoriaMod);
    }
    
    public void delete(Long id) {
        categoriaModRepository.deleteById(id);
    }

    public CategoriaMod findById(Long id) {
        Optional<CategoriaMod> categoriaModOptional = categoriaModRepository.findById(id);
        if (categoriaModOptional.isPresent()) {
            return categoriaModOptional.get();
        } else {
            throw new RuntimeException("La categoria del mod no existe");
        }
    }

    public CategoriaMod patchCategoriaMod(Long id, CategoriaMod parcialCategoriaMod){
        Optional<CategoriaMod> categoriaModOptional = categoriaModRepository.findById(id);
        if (categoriaModOptional.isPresent()) {
            
            CategoriaMod categoriaModToUpdate = categoriaModOptional.get();
            
            if (parcialCategoriaMod.getNombreCategoria() != null) {
                categoriaModToUpdate.setNombreCategoria(parcialCategoriaMod.getNombreCategoria());   
            }

            return categoriaModRepository.save(categoriaModToUpdate);
        } else {
            throw new RuntimeException("La categoria del mod no existe");
        }
    }


}
