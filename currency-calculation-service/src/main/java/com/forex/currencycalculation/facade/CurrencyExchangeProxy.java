package com.forex.currencycalculation.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.forex.currencycalculation.model.CalculatedAmount;

@FeignClient(name ="currency-exchange-service", url ="http://localhost:8001")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CalculatedAmount retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);

}
