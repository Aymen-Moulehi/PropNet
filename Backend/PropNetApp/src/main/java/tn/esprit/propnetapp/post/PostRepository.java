package tn.esprit.propnetapp.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findPostByIdPost(Integer postId);
}
