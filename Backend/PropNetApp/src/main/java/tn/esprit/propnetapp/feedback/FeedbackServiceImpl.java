package tn.esprit.propnetapp.feedback;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
}