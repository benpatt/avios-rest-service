package com.benairways.aviosrestservice;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller class that maps the get request and its parameters to the
 * PriceOptions code that handles the request.
 * 
 * @author Ben Patterson
 */
@RestController
public class PriceOptionsController {

	@GetMapping("/priceOptions")
	public PriceOptions priceOptions(
			@RequestParam(value = "DepartureAirportCode", defaultValue = "-") String departureAirportCode,
			@RequestParam(value = "ArrivalAirportCode", defaultValue = "-") String arrivalAirportCode,
			@RequestParam(value = "DepartureTime", defaultValue = "") String departureTime,
			@RequestParam(value = "ArrivalTime", defaultValue = "") String arrivalTime,
			@RequestParam(value = "Price", defaultValue = "100.00") String priceString,
			@RequestParam(value = "Currency", defaultValue = "GBP") String currency) throws IOException {
		double price = Double.parseDouble(priceString);
		return new PriceOptions(departureAirportCode, arrivalAirportCode, departureTime, arrivalTime, price, currency);
	}

}
