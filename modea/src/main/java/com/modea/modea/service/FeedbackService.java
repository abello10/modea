package com.modea.modea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modea.modea.model.Feedback;
import com.modea.modea.repository.FeedbackRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> findAll(){
        return feedbackRepository.findAll();
    }

   public Feedback save(Feedback feedback) {
    return feedbackRepository.save(feedback);
    }
    
    public void delete(Long id) {
        feedbackRepository.deleteById(id);
    }

    public Feedback findById(Long id) {
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(id);
        if (feedbackOptional.isPresent()) {
            return feedbackOptional.get();
        } else {
            throw new RuntimeException("El feedback que buscas no se encuentra");
        }
    }

    public Feedback patchFeedback(Long id, Feedback parcialFeedback){
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(id);
        if (feedbackOptional.isPresent()) {
            
            Feedback feedbackToUpdate = feedbackOptional.get();
            
            if (parcialFeedback.getDescripcionFeedback() != null) {
                feedbackToUpdate.setDescripcionFeedback(parcialFeedback.getDescripcionFeedback());   
            }

            if(parcialFeedback.getCalificacion() != null) {
                feedbackToUpdate.setCalificacion(parcialFeedback.getCalificacion());
            }

            return feedbackRepository.save(feedbackToUpdate);
        } else {
            throw new RuntimeException("El feedback que tratas de buscar no existe");
        }
    }


}
