package com.houarizegai.springopenfeign.domain.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Map;

@Data
public class ExchangeRateProviderResponse {
  private boolean success;
  private Timestamp timestamp;
  private String base;
  private String date;
  private Map<String, Double> rates;
}
