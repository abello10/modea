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

import com.modea.modea.model.Descarga;
import com.modea.modea.service.DescargaService;

@RestController
@RequestMapping("/api/v1/descargas")

public class DescargaController {

    @Autowired
    private DescargaService descargaService;

    @GetMapping
    public ResponseEntity<List<Descarga>> listar() {
        List<Descarga> descargas = descargaService.findAll();
        if (descargas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(descargas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Descarga> buscar(@PathVariable Long id) {
        try {
            Descarga descargas = descargaService.findById(id);
            return ResponseEntity.ok(descargas);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Descarga> guardar(@RequestBody Descarga descarga) {
        Descarga nuevaDescarga = descargaService.save(descarga);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaDescarga);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Descarga> actualizar(@PathVariable Long id, @RequestBody Descarga descarga) {
        try {
            Descarga actualizado = descargaService.save(descarga);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Descarga> patchFeedback(@PathVariable Long id, @RequestBody Descarga partialDescarga) {
        try {
            Descarga actualizado = descargaService.patchDescarga(id, partialDescarga);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            descargaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
