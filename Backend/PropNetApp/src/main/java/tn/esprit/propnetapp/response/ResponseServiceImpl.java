package tn.esprit.propnetapp.response;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tn.esprit.propnetapp.post.Post;
import tn.esprit.propnetapp.post.PostRepository;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class ResponseServiceImpl implements IResponseService {

    ResponseRepository responseRepository;
    PostRepository postRepository;

    @Override
    public Response addResponse(Response response) {
        return responseRepository.save(response);
    }

    @Override
    public Response addResponseAndAsginToPost(Integer idPost, Response response) {
        Post post = postRepository.findPostByIdPost(idPost);
        if(post == null)
            throw new IllegalArgumentException();
        response.setPost(post);
        return responseRepository.save(response);
    }
}