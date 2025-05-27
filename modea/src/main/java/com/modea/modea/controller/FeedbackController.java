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

import com.modea.modea.model.Feedback;
import com.modea.modea.service.FeedbackService;

@RestController
@RequestMapping("/api/v1/feedbacks")

public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<Feedback>> listar() {
        List<Feedback> feedbacks = feedbackService.findAll();
        if (feedbacks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> buscar(@PathVariable Long id) {
        try {
            Feedback feedbacks = feedbackService.findById(id);
            return ResponseEntity.ok(feedbacks);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Feedback> guardar(@RequestBody Feedback feedback) {
        Feedback nuevoFeedback = feedbackService.save(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoFeedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> actualizar(@PathVariable Long id, @RequestBody Feedback feedback) {
        try {
            Feedback actualizado = feedbackService.save(feedback);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Feedback> patchFeedback(@PathVariable Long id, @RequestBody Feedback partialFeedback) {
        try {
            Feedback actualizado = feedbackService.patchFeedback(id, partialFeedback);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            feedbackService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
