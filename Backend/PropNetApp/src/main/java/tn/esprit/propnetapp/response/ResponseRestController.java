package tn.esprit.propnetapp.response;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/response")
public class ResponseRestController {
    IResponseService responseService;

    @PostMapping("/add-response")
    public Response addResponseS(@RequestBody Response response) {
        return responseService.addResponse(response);
    }
}
