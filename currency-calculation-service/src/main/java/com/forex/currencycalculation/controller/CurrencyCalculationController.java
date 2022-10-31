package com.forex.currencycalculation.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



import com.forex.currencycalculation.model.CalculatedAmount;
import com.forex.currencycalculation.service.CurrencyCalculationService;

@RestController
public class CurrencyCalculationController {
	
	@Autowired
	private CurrencyCalculationService service;
	
	
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CalculatedAmount calculateAmount(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		return this.service.calculateAmount(from, to, quantity);
		
	}
	

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CalculatedAmount calculateAmountFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		return this.service.calculateAmountFeign(from, to, quantity);
		
	}
}
