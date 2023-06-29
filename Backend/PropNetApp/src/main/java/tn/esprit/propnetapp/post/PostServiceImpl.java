package tn.esprit.propnetapp.post;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class PostServiceImpl implements IPostService {

    PostRepository postRepository;

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(Integer postId) {
        return postRepository.findPostByIdPost(postId);
    }

    @Override
    public List<Post> getPostAccepted() {
        List<Post> acceptedPosts = postRepository.findByStatus("Accepted");
        return acceptedPosts;

    }

    @Override
    public List<Post> getPostPendding() {
        List<Post> PendingPosts = postRepository.findByStatus("Pending");
        return PendingPosts;    }

    @Override
    public List<Post> getPost() {
        return postRepository.findAll();
    }

    @Override
    public void deletePost(Integer id) {
         postRepository.deleteById(id);
    }

    @Override
    public Post updatePost(Integer id) {
        Post _post = postRepository.findPostByIdPost(id);
        _post.setStatus("Accepted");
        postRepository.save(_post);
        return _post;
    }

    @Override
    public List<Post> findByRelatedTagsInList(List<String> tags) {
        List<Post> posts = new ArrayList<>();
        for(String tag : tags){
            List<Post> matchingPosts = postRepository.findByRelatedTagsContaining(tag);
            posts.addAll(matchingPosts);
        }
        return posts.stream().distinct().collect(Collectors.toList());
    }


}