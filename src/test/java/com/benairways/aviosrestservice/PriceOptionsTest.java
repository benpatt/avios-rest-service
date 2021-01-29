package com.benairways.aviosrestservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.benairways.aviosrestservice.PriceOptions.FlightCodes;

@SpringBootTest
public class PriceOptionsTest {

	/**
	 * Test the constructor builds the correct price options correctly
	 */
	@Test
	void constructor() throws IOException {
		PriceOptions po = new PriceOptions("LHR", "LAX", "", "", 100.0, "GBP");
		PricePoint[] pps = po.getPricePoints();
		assertEquals(4, pps.length);

		assertEquals(20, pps[0].getDiscountPercentage());
		assertEquals(20.0, pps[0].getDiscountCost());
		assertEquals(714, pps[0].getAviosCost());

		assertEquals(50, pps[1].getDiscountPercentage());
		assertEquals(50.0, pps[1].getDiscountCost());
		assertEquals(1786, pps[1].getAviosCost());

		assertEquals(70, pps[2].getDiscountPercentage());
		assertEquals(70.0, pps[2].getDiscountCost());
		assertEquals(2500, pps[2].getAviosCost());

		assertEquals(100, pps[3].getDiscountPercentage());
		assertEquals(100.0, pps[3].getDiscountCost());
		assertEquals(3571, pps[3].getAviosCost());
	}

	/**
	 * Test the flight code values are read from the database correctly
	 */
	@Test
	void getFlightCodeValues() throws IOException {
		PriceOptions po = new PriceOptions();
		Map<FlightCodes, Double> fcvs = po.getFlightCodeValues("src/main/resources/avios-value-table.csv");
		assertEquals(6, fcvs.size());
		// Expected codes and values per avios
		FlightCodes[] codes = { new FlightCodes("LHR", "LAX"), new FlightCodes("LHR", "AMS"),
				new FlightCodes("LHR", "JFK"), new FlightCodes("LGW", "LAX"), new FlightCodes("LGW", "MUC"),
				new FlightCodes("-", "-") };
		double[] aviosVals = { 0.028, 0.025, 0.03, 0.027, 0.024, 0.02 };
		for (int i = 0; i < codes.length; i++) {
			assertEquals(aviosVals[i], fcvs.get(codes[i]));
		}
	}

}
