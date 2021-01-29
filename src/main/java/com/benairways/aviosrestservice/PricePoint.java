package com.benairways.aviosrestservice;

/**
 * A simple class representing flight price points to be marshalled to JSON for
 * GET requests.
 * 
 * @author Ben Patterson
 */
public class PricePoint {

	// Including discount percentage in the GET response for clarity
	private int discountPercentage;
	private double discountCost;
	private int aviosCost;

	/**
	 * Construct a PricePoint object by calculating the discount from the price and
	 * the avios cost from the discount percentage.
	 * 
	 * @param discountPercentage The percentage discount for the flight
	 * @param price              The original price of the flight
	 * @param valPerAvios        The percentage discount value per avios point for
	 *                           the flight
	 */
	public PricePoint(int discountPercentage, double price, double valPerAvios) {
		this.discountPercentage = discountPercentage;
		this.discountCost = (0.01 * discountPercentage) * price;
		this.aviosCost = (int) Math.round(discountPercentage / valPerAvios);
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public double getDiscountCost() {
		return discountCost;
	}

	public int getAviosCost() {
		return aviosCost;
	}

}
