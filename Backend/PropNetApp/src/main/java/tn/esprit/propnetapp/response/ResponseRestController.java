package tn.esprit.propnetapp.response;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/response")
public class ResponseRestController {
    IResponseService responseService;

    @PostMapping("/add-response")
    @CrossOrigin
    public Response addResponse(@RequestBody Response response) {
        return responseService.addResponse(response);
    }

    @PostMapping("/add-and-asgin-response-to-post/{postId}")
    @CrossOrigin
    public Response addAndAsginResponseToPost(@PathVariable("postId") Integer postId, @RequestBody Response response) {
        return responseService.addResponseAndAsginToPost(postId, response);
    }
}
