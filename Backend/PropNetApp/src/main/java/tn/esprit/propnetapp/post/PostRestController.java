package tn.esprit.propnetapp.post;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostRestController {
    IPostService postService;

    @PostMapping("/add-post")
    public Post addPostS(@RequestBody Post post) {
        return postService.addPost(post);
    }
}
