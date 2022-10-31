package com.forex.currencycalculation.service;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PathVariable;

import com.forex.currencycalculation.model.CalculatedAmount;

public interface CurrencyCalculationService {
	
	public CalculatedAmount calculateAmount(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity);
	
	public CalculatedAmount calculateAmountFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity);

}
