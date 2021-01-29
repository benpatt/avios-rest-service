package com.benairways.aviosrestservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * A class to test the functionality of the PricePoint class
 * 
 * @author Ben Patterson
 */
@SpringBootTest
public class PricePointTest {

	/**
	 * Test the constructor performs the arithmetic correctly
	 */
	@Test
	void constructor() {
		PricePoint pp = new PricePoint(50, 100.0, 0.1);
		assertEquals(50.0, pp.getDiscountCost());
		assertEquals(500, pp.getAviosCost());
	}

}
