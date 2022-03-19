package com.houarizegai.springbatchapp.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankTransaction {

    @Id
    private Long id;
    private Long accountId;
    private Date transactionDate;
    @Transient
    private String strTransactionDate;
    private String transactionType;
    private double amount;
}
