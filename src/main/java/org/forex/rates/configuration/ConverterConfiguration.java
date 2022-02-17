package org.forex.rates.configuration;

import org.forex.rates.converter.ExchangeRateInputResourceToExchangeRateConverter;
import org.forex.rates.converter.ExchangeRateListToExchangeRateSeriesResourceConverter;
import org.forex.rates.converter.ExchangeRateToExchangeRateResourceConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.convert.support.GenericConversionService;

@Configuration
public class ConverterConfiguration {

    @Bean
    public ConfigurableConversionService exchangeRateConversionService() {
        final ConfigurableConversionService conversionService = new GenericConversionService();
        conversionService.addConverter(new ExchangeRateToExchangeRateResourceConverter());
        conversionService.addConverter(new ExchangeRateListToExchangeRateSeriesResourceConverter());
        conversionService.addConverter(new ExchangeRateInputResourceToExchangeRateConverter());
        return conversionService;
    }
}
