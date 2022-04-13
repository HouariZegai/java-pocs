package com.houarizegai.springopenfeign.controller;

import com.houarizegai.springopenfeign.client.ExchangeRateProviderClient;
import com.houarizegai.springopenfeign.domain.dto.ExchangeRateProviderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exchange-rate")
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateProviderClient exchangeRateProviderClient;


    @GetMapping
    public ExchangeRateProviderResponse getExchangeRates() {
        return exchangeRateProviderClient.getExchangeRates();
    }
}
