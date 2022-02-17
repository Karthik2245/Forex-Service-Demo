package org.forex.rates.converter;

import org.forex.rates.model.entity.ExchangeRate;
import org.forex.rates.model.dto.ExchangeRateInputResource;
import org.springframework.core.convert.converter.Converter;

import static org.forex.rates.model.Currency.EUR;
import static org.forex.rates.model.Currency.USD;

public class ExchangeRateInputResourceToExchangeRateConverter implements Converter<ExchangeRateInputResource, ExchangeRate> {

    @Override
    public ExchangeRate convert(ExchangeRateInputResource exchangeRateInputResource) {
        if (exchangeRateInputResource == null)
            return null;

        return new ExchangeRate(null, exchangeRateInputResource.getDate(),
                EUR,
                USD,
                exchangeRateInputResource.getRates().getEur());
    }
}
