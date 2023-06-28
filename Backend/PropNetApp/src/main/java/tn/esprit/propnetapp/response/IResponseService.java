package tn.esprit.propnetapp.response;

public interface IResponseService {
    Response addResponse(Response response);
    Response addResponseAndAsginToPost(Integer idPost, Response response);
}