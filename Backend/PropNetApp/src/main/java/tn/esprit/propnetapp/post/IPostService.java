package tn.esprit.propnetapp.post;

public interface IPostService {
    Post addPost(Post post);
    Post getPostById(Integer postId);
}