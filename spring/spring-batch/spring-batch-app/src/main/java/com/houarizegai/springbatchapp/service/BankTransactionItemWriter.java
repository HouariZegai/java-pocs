package com.houarizegai.springbatchapp.service;

import com.houarizegai.springbatchapp.domain.entity.BankTransaction;
import com.houarizegai.springbatchapp.repository.BankTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BankTransactionItemWriter implements ItemWriter<BankTransaction> {

    private final BankTransactionRepository bankTransactionRepository;

    @Override
    public void write(List<? extends BankTransaction> list) {
        bankTransactionRepository.saveAll(list);
    }
}
