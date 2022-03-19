package com.houarizegai.springbatchapp.config;

import com.houarizegai.springbatchapp.domain.entity.BankTransaction;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class BankTransactionItemReaderConfig {

    @Bean
    public FlatFileItemReader<BankTransaction> flatFileItemReader(@Value("${inputFilePath}") Resource resource) {
        FlatFileItemReader<BankTransaction> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setName("csv-reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setLineMapper(lineMapper());

        return flatFileItemReader;
    }

    public LineMapper<BankTransaction> lineMapper() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "accountId", "strTransactionDate", "transactionType", "amount");

        BeanWrapperFieldSetMapper<BankTransaction> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(BankTransaction.class);

        DefaultLineMapper<BankTransaction> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }
}
