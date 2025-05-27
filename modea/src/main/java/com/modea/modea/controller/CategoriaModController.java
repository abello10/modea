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

import com.modea.modea.model.CategoriaMod;
import com.modea.modea.service.CategoriaModService;

@RestController
@RequestMapping("/api/v1/categoriamods")

public class CategoriaModController {

    @Autowired
    private CategoriaModService categoriaModService;

    @GetMapping
    public ResponseEntity<List<CategoriaMod>> listar() {
        List<CategoriaMod> categoriaMods = categoriaModService.findAll();
        if (categoriaMods.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categoriaMods);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaMod> buscar(@PathVariable Long id) {
        try {
            CategoriaMod categoriaMods = categoriaModService.findById(id);
            return ResponseEntity.ok(categoriaMods);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CategoriaMod> guardar(@RequestBody CategoriaMod categoriaMod) {
        CategoriaMod nuevaCategoriaMod = categoriaModService.save(categoriaMod);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoriaMod);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaMod> actualizar(@PathVariable Long id, @RequestBody CategoriaMod categoriaMod) {
        try {
            CategoriaMod actualizado = categoriaModService.save(categoriaMod);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoriaMod> patchCategoriaMod(@PathVariable Long id, @RequestBody CategoriaMod partialCategoriaMod) {
        try {
            CategoriaMod actualizado = categoriaModService.patchCategoriaMod(id, partialCategoriaMod);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            categoriaModService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
