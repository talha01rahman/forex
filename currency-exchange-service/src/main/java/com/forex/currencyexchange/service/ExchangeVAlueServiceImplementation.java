package com.forex.currencyexchange.service;

import com.forex.currencyexchange.model.ExchangeValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.forex.currencyexchange.repository.ExchangeValueRepository;

@Service
public class ExchangeVAlueServiceImplementation implements ExchangeValueService {
    
	
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	
	
	public ExchangeVAlueServiceImplementation() {
		
	}



	@Override
	public ExchangeValue retrieveExchangeValue(String from, String to) {
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}



	@Override
	public List<ExchangeValue> getForex() {
		return repository.findAll();
	}

}
