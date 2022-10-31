package com.forex.currencyexchange.service;

import java.util.List;

import com.forex.currencyexchange.model.ExchangeValue;

public interface ExchangeValueService {
	
	public ExchangeValue retrieveExchangeValue(String from, String to);
	
	public List<ExchangeValue> getForex(); 
}
