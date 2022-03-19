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
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.convert.Delimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;

import java.util.Date;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class SpringBatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final ItemReader<BankTransaction> bankTransactionItemReader;
    private final ItemProcessor<BankTransaction, BankTransaction> bankTransactionItemProcessor;
    private final ItemWriter<BankTransaction> bankTransactionItemWriter;

    @Bean
    public Job bankJob() {
        Step step = stepBuilderFactory.get("load-data-step")
                .<BankTransaction, BankTransaction>chunk(100)
                .reader(bankTransactionItemReader)
                .processor(bankTransactionItemProcessor)
                .writer(bankTransactionItemWriter)
                .build();

        return jobBuilderFactory.get("bank-data-loader-job").start(step).build();
    }
}
