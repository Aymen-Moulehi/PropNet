package tn.esprit.propnetapp.feedback;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/feedback")
public class FeedbackRestController {
    IFeedbackService feedbackService;

    @PostMapping("/add-feedback")
    public Feedback addFeedbackS(@RequestBody Feedback feedback) {
        return feedbackService.addFeedback(feedback);
    }
}
