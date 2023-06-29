package tn.esprit.propnetapp.batch;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/batch")
public class BatchController {
    private JobLauncher jobLauncher;
    private ApplicationContext context;

    @PostMapping("{batchType}")
    public void runBatchByType(@PathVariable("batchType") BatchType batchType) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis())
                .toJobParameters();
        Job job = null;

        switch (batchType) {
            case LOAD_POST_DATA:
                job = context.getBean("loadPostData", Job.class);
                break;
            default:
        }
        if(job != null) {
            log.info("Start running the batch...");
            jobLauncher.run(job, jobParameters);
        }

    }

}
