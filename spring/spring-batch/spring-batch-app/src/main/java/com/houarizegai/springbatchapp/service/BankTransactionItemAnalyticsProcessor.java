package com.houarizegai.springbatchapp.service;

import com.houarizegai.springbatchapp.domain.entity.BankTransaction;
import lombok.Getter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bankItemAnalyticsProcessor")
@Getter
public class BankTransactionItemAnalyticsProcessor implements ItemProcessor<BankTransaction, BankTransaction> {

    private double totalDebit;
    private double totalCredit;

    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
        if(bankTransaction.getTransactionType().equals("D")) {
            totalDebit += bankTransaction.getAmount();
        } else if (bankTransaction.getTransactionType().equals("C")) {
            totalCredit += bankTransaction.getAmount();
        }

        return bankTransaction;
    }
}
