package tn.esprit.propnetapp.feedback;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class FeedbackServiceImpl implements IFeedbackService {

    FeedbackRepository feedbackRepository;

    @Override
    public Feedback addFeedback(Feedback feedback) {

        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> retrieveAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback updateFeedback(Feedback f) {
        return feedbackRepository.save(f);
    }

    @Override
    public Feedback retrieveFeedback(Integer idFeedback) {
        return feedbackRepository.findById(idFeedback).get();
    }

    @Override
    public void deleteFeedback(Integer idFeedback) {
        feedbackRepository.deleteById(idFeedback);

    }
}