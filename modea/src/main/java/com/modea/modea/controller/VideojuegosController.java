package com.modea.modea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modea.modea.model.Videojuego;
import com.modea.modea.service.VideojuegoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/v1/videojuegos")

public class VideojuegosController {

    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping
    public ResponseEntity<List<Videojuego>> listar() {
        List<Videojuego> videojuegos = videojuegoService.findAll();
        if (videojuegos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(videojuegos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Videojuego> buscar(@PathVariable Long id) {
        try {
            Videojuego videojuego = videojuegoService.findById(id);
            return ResponseEntity.ok(videojuego);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Videojuego> guardar(@RequestBody Videojuego videojuego) {
        Videojuego nuevoVideojuego = videojuegoService.save(videojuego);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoVideojuego);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Videojuego> actualizar(@PathVariable Long id, @RequestBody Videojuego videojuego) {
        try {
            Videojuego actualizado = videojuegoService.save(videojuego);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Videojuego> patchVideojuego(@PathVariable Long id, @RequestBody Videojuego partialVideojuego) {
        try {
            Videojuego actualizado = videojuegoService.patchVideojuego(id, partialVideojuego);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            videojuegoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

    
    
