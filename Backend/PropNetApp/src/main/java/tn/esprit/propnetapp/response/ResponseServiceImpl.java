package tn.esprit.propnetapp.response;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Aspect
@Component
@Slf4j
public class ResponseServiceImpl implements IResponseService {

    ResponseRepository responseRepository;

    @Override
    public Response addResponse(Response response) {
        return responseRepository.save(response);
    }
}