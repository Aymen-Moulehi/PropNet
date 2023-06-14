package tn.esprit.propnetapp.feedback;

import tn.esprit.propnetapp.claim.Claim;

import java.util.List;

public interface IFeedbackService {
    Feedback addFeedback(Feedback feedback);
    List<Feedback> retrieveAllFeedback();
    Feedback updateFeedback (Feedback f);

    Feedback retrieveFeedback (Integer idFeedback);

    void deleteFeedback(Integer idFeedback);
}