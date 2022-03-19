package com.houarizegai.springbatchapp.service;

import com.houarizegai.springbatchapp.domain.entity.BankTransaction;
import com.houarizegai.springbatchapp.repository.BankTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BankTransactionItemWriter implements ItemWriter<BankTransaction> {

    private final BankTransactionRepository bankTransactionRepository;

    private final Logger logger = LoggerFactory.getLogger(BankTransactionItemWriter.class);

    @Override
    public void write(List<? extends BankTransaction> list) throws Exception {
        bankTransactionRepository.saveAll(list);
    }
}
