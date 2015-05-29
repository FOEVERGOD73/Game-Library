package com.FOEVERGOD73.Util;

/**
 * Fraction class Represents fractions, always reduced to lowest terms. If
 * fraction is negative, the numerator will always be negative. All operators
 * leave results stored in lowest terms.
 *
 */

public class Fraction {
	private int numerator; // Fraction numerator
	private int denominator; // Fraction denominator

	/**
	 * @Constructor Initialized to 0/1
	 */
	public Fraction() {
		numerator = 0;
		denominator = 1;
	}

	/**
	 * @Constructor Initialized to num/1
	 * @param num
	 *            Value over 1
	 */
	public Fraction(int num) {
		numerator = num;
		denominator = 1;
	}

	/**
	 * @Constructor If fraction is negative the negative is stored in the
	 *              numerator
	 * @param num
	 *            Numerator
	 * @param denom
	 *            Denominator
	 */
	public Fraction(int num, int denom) {
		numerator = (denom < 0 ? -num : num);
		if (denom == 0) {
			denominator = 1;
		}
		denominator = (denom < 0 ? -denom : denom);
		reduce();
	}

	/**
	 * Set Numerator To Specified Value
	 * 
	 * @param num
	 *            Numerator Value
	 */
	public void setNumerator(int num) {
		numerator = num;
		reduce();
	}

	/**
	 * @return Numerator
	 */
	public int getNumerator() {
		return numerator;
	}

	/**
	 * setDenominator denominator is set to be the given parameter (zero is
	 * ignored), if denominator is negative, numerator is adjusted
	 * 
	 * @param denom
	 *            Denominator
	 **/
	public void setDenominator(int denom) {
		if (denom > 0) {
			denominator = denom;
			reduce();
		} else if (denom < 0) {
			numerator = -numerator;
			denominator = -denom;
			reduce();
		}
	}

	/**
	 * 
	 * @return Denominator
	 */
	public int getDenominator() {
		return denominator;
	}

	/**
	 * 
	 * @param fraction
	 *            The Fraction To Add
	 * @return Returns the result in a new Fraction Object
	 */
	public Fraction add(Fraction fraction) {
		Fraction sum = new Fraction();
		sum.denominator = denominator * fraction.denominator;
		sum.numerator = numerator * fraction.denominator + denominator
				* fraction.numerator;
		sum.reduce();
		return sum;
	}
	/**
	 * Adds the 2 Fractions together
	 * @return Returns the result in a new Fraction Object
	 */
	public static Fraction add(Fraction fraction1, Fraction fraction2) {
		Fraction sum = new Fraction();
		sum.denominator = fraction1.denominator * fraction2.denominator;
		sum.numerator = fraction1.numerator * fraction2.denominator + fraction1.denominator
				* fraction2.numerator;
		sum.reduce();
		return sum;
	}
	
	/**
	 * Subtracts the parameter Fraction from the original Fraction
	 * 
	 * @param fraction
	 *            The Fraction To Subtract
	 * @return Returns the result in a new Fraction Object
	 */
	public Fraction subtract(Fraction fraction){
		Fraction diff = new Fraction();
		diff.denominator = denominator * fraction.denominator;
		diff.numerator = numerator * fraction.denominator - denominator
				* fraction.numerator;
		diff.reduce();
		return diff;
	}
	
	/**
	 * Subtracts the Second Fraction from the First Fraction
	 * @return Returns the result in a new Fraction Object
	 */
	public static Fraction subtract(Fraction fraction1, Fraction fraction2) {
		Fraction sum = new Fraction();
		sum.denominator = fraction1.denominator * fraction2.denominator;
		sum.numerator = fraction1.numerator * fraction2.denominator + fraction1.denominator
				* fraction2.numerator;
		sum.reduce();
		return sum;
	}
	
	/**
	 * Multiplies the fractions together
	 * @return Returns the result in a new Fraction Object
	 */
	public Fraction multiply(Fraction fraction){
		Fraction product = new Fraction();
		product.denominator = denominator * fraction.denominator;
		product.numerator = numerator * fraction.numerator;
		product.reduce();
		return product;
	}
	
	/**
	 * Multiplies the fractions together
	 * @return Returns the result in a new Fraction Object
	 */
	public static Fraction multiply(Fraction fraction1, Fraction fraction2){
		Fraction product = new Fraction();
		product.denominator = fraction1.denominator * fraction2.denominator;
		product.numerator = fraction1.numerator * fraction2.numerator;
		product.reduce();
		return product;
	}
	
	/**
	 * Divides the Original Fraction by the Parameter Fraction
	 * @return Returns the result in a new Fraction Object
	 */
	public Fraction divide(Fraction fraction){
		Fraction product = new Fraction();
		product.denominator = denominator * fraction.denominator;
		product.numerator = numerator * fraction.numerator;
		product.reduce();
		return product;
	}
	
	/**
	 * Divides the First Fraction by the Second Fraction
	 * @return Returns the result in a new Fraction Object
	 */
	public static Fraction divide(Fraction fraction1, Fraction fraction2){
		Fraction quotient = new Fraction();
		quotient.denominator = fraction1.denominator * fraction2.numerator;
		quotient.numerator = fraction1.numerator * fraction2.denominator;
		quotient.reduce();
		return quotient;
	}

	/**
	 * toString convert the Fraction to a String object, e.g., 2/3
	 */
	public String toString() {
		return numerator + "/" + denominator;
	}

	public boolean equals(Fraction rhs) {
		return (numerator == rhs.numerator) && (denominator == rhs.denominator);
	}

	/**
	 * reduce reduce Fraction to lowest terms by finding largest common
	 * denominator and dividing it out
	 */
	private void reduce() {
		// find the larger of the numerator and denominator
		int n = numerator, d = denominator, largest;
		if (numerator < 0) {
			n = -numerator;
		}
		if (n > d) {
			largest = n;
		} else {
			largest = d;
		}

		// find the largest number that divide the numerator and
		// denominator evenly
		int gcd = 0;
		for (int i = largest; i >= 2; i--) {
			if (numerator % i == 0 && denominator % i == 0) {
				gcd = i;
				break;
			}
		}

		// divide the largest common denominator out of numerator, denominator
		if (gcd != 0) {
			numerator /= gcd;
			denominator /= gcd;
		}
	}
}
