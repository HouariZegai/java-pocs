package com.houarizegai.springbatchapp.config;

import com.houarizegai.springbatchapp.domain.entity.BankTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class SpringBatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final ItemReader<BankTransaction> bankTransactionItemReader;
    private final ItemWriter<BankTransaction> bankTransactionItemWriter;

    @Qualifier("bankItemProcessor")
    private final ItemProcessor<BankTransaction, BankTransaction> bankTransactionItemProcessor;
    @Qualifier("bankItemAnalyticsProcessor")
    private final ItemProcessor<BankTransaction, BankTransaction> bankTransactionItemAnalyticsProcessor;

    @Bean
    public Job bankJob() {
        Step step = stepBuilderFactory.get("load-data-step")
                .<BankTransaction, BankTransaction>chunk(100)
                .reader(bankTransactionItemReader)
                .processor(compositeItemProcessor())
                .writer(bankTransactionItemWriter)
                .build();

        return jobBuilderFactory.get("bank-data-loader-job").start(step).build();
    }


    public ItemProcessor<? super BankTransaction, ? extends BankTransaction> compositeItemProcessor() {
        List<ItemProcessor<BankTransaction, BankTransaction>> processorList = new ArrayList<>();
        processorList.add(bankTransactionItemProcessor);
        processorList.add(bankTransactionItemAnalyticsProcessor);

        CompositeItemProcessor<BankTransaction, BankTransaction> compositeItemProcessor = new CompositeItemProcessor<>();
        compositeItemProcessor.setDelegates(processorList);

        return compositeItemProcessor;
    }
}
