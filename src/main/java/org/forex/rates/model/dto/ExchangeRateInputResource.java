package org.forex.rates.model.dto;


import lombok.Getter;

import java.util.Date;

@Getter
public class ExchangeRateInputResource {

    private String base;
    private Date date;
    private ExchangeRateInputResourceDetail rates;
}
