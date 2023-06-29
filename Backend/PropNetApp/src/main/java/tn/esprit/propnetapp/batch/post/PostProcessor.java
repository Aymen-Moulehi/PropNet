package tn.esprit.propnetapp.batch.post;

import org.springframework.batch.item.ItemProcessor;
import tn.esprit.propnetapp.post.Post;

import java.util.Date;

public class PostProcessor implements ItemProcessor<Post, Post> {
    @Override
    public Post process(Post post) throws Exception {
        if(post != null)
            post.setPostDate(new Date());
        return post;
    }
}
