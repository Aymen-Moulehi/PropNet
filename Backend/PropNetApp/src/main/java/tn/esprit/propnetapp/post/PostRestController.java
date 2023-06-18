package tn.esprit.propnetapp.post;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostRestController {
    IPostService postService;

    @PostMapping("/add-post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post) {
        if(post != null)
            post.setPostDate(new Date());
        System.out.println(post.getPostDate());
        return postService.addPost(post);
    }

    @GetMapping("/find-post/{id}")
    @CrossOrigin
    public Post findPostById(@PathVariable("id") Integer postId) {
        return postService.getPostById(postId);
    }
}


