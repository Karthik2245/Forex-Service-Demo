package org.forex.rates.schedule;

import org.forex.rates.client.FixerExchangeRateClient;
import org.forex.rates.model.entity.ExchangeRate;
import org.forex.rates.model.dto.ExchangeRateInputResource;
import org.forex.rates.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateDataProviderJob {

    private FixerExchangeRateClient fixerExchangeRateClient;
    private ExchangeRateService exchangeRateService;
    private ConversionService exchangeRateConversionService;


    @Autowired
    public ExchangeRateDataProviderJob(FixerExchangeRateClient fixerExchangeRateClient,
                                       ExchangeRateService exchangeRateService,
                                       ConversionService exchangeRateConversionService)
    {
        this.fixerExchangeRateClient = fixerExchangeRateClient;
        this.exchangeRateService = exchangeRateService;
        this.exchangeRateConversionService = exchangeRateConversionService;
    }

    @Scheduled(cron = "${scheduled.execution.cron}")
    void saveCurrentExchangeRate(){

        ExchangeRateInputResource rir = fixerExchangeRateClient.latest();

        ExchangeRate rate = exchangeRateConversionService.convert(rir, ExchangeRate.class);

        exchangeRateService.save(rate);
    }

}
