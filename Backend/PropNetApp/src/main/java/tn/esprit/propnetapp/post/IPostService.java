package tn.esprit.propnetapp.post;

import java.util.List;

public interface IPostService {
    Post addPost(Post post);
    Post getPostById(Integer postId);
    List<Post> getPostAccepted();
    List<Post> getPostPendding();

    List<Post> getPost();

    void deletePost(Integer id);
    void updatePost(Integer id);

    List<Post> findByRelatedTagsInList(List<String> tags);


}