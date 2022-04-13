package com.houarizegai.springopenfeign.client;

import com.houarizegai.springopenfeign.domain.dto.ExchangeRateProviderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "exchangerate", url = "${exchange-rates.provider.url}")
public interface ExchangeRateProviderClient {

    @GetMapping
    ExchangeRateProviderResponse getExchangeRates();
}
