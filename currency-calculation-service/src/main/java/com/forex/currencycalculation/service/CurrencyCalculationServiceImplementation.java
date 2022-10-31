package com.forex.currencycalculation.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.forex.currencycalculation.facade.CurrencyExchangeProxy;
import com.forex.currencycalculation.model.CalculatedAmount;

@Service
public class CurrencyCalculationServiceImplementation implements CurrencyCalculationService {

	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@Override
	public CalculatedAmount calculateAmount(String from, String to, BigDecimal quantity) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CalculatedAmount> responseEntity = new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}"
				, CalculatedAmount.class, uriVariables);
		
		CalculatedAmount calculatedAmount =responseEntity.getBody();
		return new CalculatedAmount(calculatedAmount.getId(), calculatedAmount.getFrom(), 
				calculatedAmount.getTo(), calculatedAmount.getConversionMultiple(),
				quantity, quantity.multiply(calculatedAmount.getConversionMultiple()), 
				calculatedAmount.getPort());
	}

	@Override
	public CalculatedAmount calculateAmountFeign(String from, String to, BigDecimal quantity) {
    
		CalculatedAmount calculatedAmount= proxy.retrieveExchangeValue(from, to);
		
		System.out.println(calculatedAmount.toString());
		
		return new CalculatedAmount(calculatedAmount.getId(), calculatedAmount.getFrom(), 
				calculatedAmount.getTo(), calculatedAmount.getConversionMultiple(),
				quantity, quantity.multiply(calculatedAmount.getConversionMultiple()), 
				calculatedAmount.getPort());
	}

}
