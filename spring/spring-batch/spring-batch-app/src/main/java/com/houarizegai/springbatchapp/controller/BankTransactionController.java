package com.houarizegai.springbatchapp.controller;

import com.houarizegai.springbatchapp.service.BankTransactionItemAnalyticsProcessor;
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
    private final BankTransactionItemAnalyticsProcessor analyticsProcessor;

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

    @GetMapping("/analytics")
    public Map<String, Double> getAnalytics() {
        Map<String, Double> analytics = new HashMap<>();
        analytics.put("credit", analyticsProcessor.getTotalCredit());
        analytics.put("debit", analyticsProcessor.getTotalDebit());

        return analytics;
    }
}
