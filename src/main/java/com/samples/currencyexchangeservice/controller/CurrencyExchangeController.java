package com.samples.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;
@RestController
public class CurrencyExchangeController {

    @Autowired
    private ExchangeValueRepository repository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue
            (@PathVariable String from, @PathVariable String to){

        ExchangeValue exchangeValue =
                repository.findByFromAndTo(from, to);
        String port = environment.getProperty("local.server.port");
// environment.getProperty("local.server.port")
        exchangeValue.setPort(
                Integer.parseInt(port));

//return  new ExchangeValue(100L,from,to, BigDecimal.valueOf((65)));
        return  exchangeValue;
    }
}
