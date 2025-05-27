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

import com.modea.modea.model.Mod;
import com.modea.modea.service.ModService;

@RestController
@RequestMapping("/api/v1/mods")


public class ModController {

    @Autowired
    private ModService modService;

    @GetMapping
    public ResponseEntity<List<Mod>> listar() {
        List<Mod> mods = modService.findAll();
        if (mods.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mods);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mod> buscar(@PathVariable Long id) {
        try {
            Mod mods = modService.findById(id);
            return ResponseEntity.ok(mods);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Mod> guardar(@RequestBody Mod mod) {
        Mod nuevoMod = modService.save(mod);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMod);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mod> actualizar(@PathVariable Long id, @RequestBody Mod mod) {
        try {
            Mod actualizado = modService.save(mod);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Mod> patchMod(@PathVariable Long id, @RequestBody Mod partialMod) {
        try {
            Mod actualizado = modService.patchMod(id, partialMod);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            modService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
