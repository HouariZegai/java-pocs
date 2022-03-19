package com.houarizegai.springbatchapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BankTransactionController {

    private final JobLauncher jobLauncher;
    private final Job job;

    @GetMapping("/startJob")
    public BatchStatus load() throws Exception {
        Map<String, JobParameter> params = new HashMap<>();
        params.put("time", new JobParameter(System.currentTimeMillis()));

        JobParameters jobParams = new JobParameters(params);
        JobExecution jobExecution = jobLauncher.run(job, jobParams);
        while (jobExecution.isRunning()) {
            System.out.println("...");
        }

        return jobExecution.getStatus();
    }
}
