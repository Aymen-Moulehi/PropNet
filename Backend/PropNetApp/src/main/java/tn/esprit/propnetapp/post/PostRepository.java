package tn.esprit.propnetapp.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findPostByIdPost(Integer postId);
    List<Post> findByStatus(String status);
    List<Post> findByRelatedTagsContaining(String tag);

}
