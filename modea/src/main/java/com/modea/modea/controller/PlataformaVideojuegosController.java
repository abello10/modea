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

import com.modea.modea.model.PlataformaVideojuego;
import com.modea.modea.service.PlataformaVideojuegoService;

@RestController
@RequestMapping("/api/v1/plataformavideojuegos")


public class PlataformaVideojuegosController {

    
    @Autowired
    private PlataformaVideojuegoService plataformaVideojuegoService;

    @GetMapping
    public ResponseEntity<List<PlataformaVideojuego>> listar() {
        List<PlataformaVideojuego> plataformaVideojuegos = plataformaVideojuegoService.findAll();
        if (plataformaVideojuegos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(plataformaVideojuegos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlataformaVideojuego> buscar(@PathVariable Long id) {
        try {
            PlataformaVideojuego plataformaVideojuego = plataformaVideojuegoService.findById(id);
            return ResponseEntity.ok(plataformaVideojuego);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PlataformaVideojuego> guardar(@RequestBody PlataformaVideojuego plataformaVideojuego) {
        PlataformaVideojuego nuevaPlataformaVideojuego = plataformaVideojuegoService.save(plataformaVideojuego);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPlataformaVideojuego);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlataformaVideojuego> actualizar(@PathVariable Long id, @RequestBody PlataformaVideojuego plataformaVideojuego) {
        try {
            PlataformaVideojuego actualizado = plataformaVideojuegoService.save(plataformaVideojuego);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PlataformaVideojuego> patchPlataformaVideojuego(@PathVariable Long id, @RequestBody PlataformaVideojuego partialPlataformaVideojuego) {
        try {
            PlataformaVideojuego actualizado = plataformaVideojuegoService.patchPlataformaVideojuego(id, partialPlataformaVideojuego);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            plataformaVideojuegoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
