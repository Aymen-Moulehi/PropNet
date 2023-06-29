package tn.esprit.propnetapp.feedback;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/feedback")
@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackRestController {
    IFeedbackService feedbackService;

    @PostMapping("/add-feedback")
    public Feedback addFeedbackS(@RequestBody Feedback feedback) {

        return feedbackService.addFeedback(feedback);
    }

    @GetMapping("/retrieveAllfeedback")
    public List<Feedback> getFeedback() {
        List<Feedback> listFeedback = feedbackService.retrieveAllFeedback();
        return listFeedback;
    }
    @GetMapping("/retrieve-feedback/{feedback-id}")
    public Feedback retrieveFeedback(@PathVariable("feedback-id")  Integer idfeedback) {
        return feedbackService.retrieveFeedback(idfeedback);
    }
    @DeleteMapping("/delete-feedback/{feedback-id}")
    public void deletefeedback(@PathVariable("feedback-id") Integer idfeedback) {

        feedbackService.deleteFeedback(idfeedback);
    }
    @PutMapping("/update-feedback")
    public Feedback updatefeedback(@RequestBody Feedback feedback) {

        return feedbackService.updateFeedback(feedback);
    }
}
