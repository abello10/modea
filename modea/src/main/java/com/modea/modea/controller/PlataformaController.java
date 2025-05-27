package com.modea.modea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modea.modea.model.Plataforma;
import com.modea.modea.service.PlataformaService;

@RestController
@RequestMapping("/api/v1/plataformas")

public class PlataformaController {

    
    @Autowired
    private PlataformaService plataformaService;

    @GetMapping
    public ResponseEntity<List<Plataforma>> listar() {
        List<Plataforma> plataformas = plataformaService.findAll();
        if (plataformas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(plataformas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plataforma> buscar(@PathVariable Long id) {
        try {
            Plataforma plataformas = plataformaService.findById(id);
            return ResponseEntity.ok(plataformas);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Plataforma> guardar(@RequestBody Plataforma plataformas) {
        Plataforma nuevaPlataforma = plataformaService.save(plataformas);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPlataforma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plataforma> actualizar(@PathVariable Long id, @RequestBody Plataforma plataforma) {
        try {
            Plataforma actualizado = plataformaService.save(plataforma);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Plataforma> patchPlataforma(@PathVariable Long id, @RequestBody Plataforma partialPlataforma) {
        try {
            Plataforma actualizado = plataformaService.patchPlataforma(id, partialPlataforma);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            plataformaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    

}
