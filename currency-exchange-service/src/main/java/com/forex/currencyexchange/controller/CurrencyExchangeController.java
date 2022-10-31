package com.forex.currencyexchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.forex.currencyexchange.model.ExchangeValue;

import com.forex.currencyexchange.service.ExchangeValueService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CurrencyExchangeController {
	
    @Autowired
	private ExchangeValueService service;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
        return this.service.retrieveExchangeValue(from, to);
	}
	
	@GetMapping("/currency-exchange")
	public List<ExchangeValue> getForex(){
		return this.service.getForex();
	}
	
}