package assignment1;

public class Fraction {
	//PROPERTIES
	
	//Instance Variables
	private int numerator = 0;
	private int denominator = 0;
	
	//Constructor
	public Fraction(int numerator, int denominator) {
		int g = gcd(denominator, numerator);
		if (g != numerator) {
			int x = simplifyDenominator (denominator, g);
			int y = simplifyNumerator (numerator, g);
			this.numerator = y;
			this.denominator = x;
		} else {	
		this.numerator = numerator;
		this.denominator = denominator;
		}
	}
	
	//BEHAVIORS
	
	//Instance Methods
	public String toString() {
		Float.toString(denominator);
		Float.toString(numerator);
		return numerator + "/" + denominator;
		
	}
	public float toDecimal() {
		float n = (float) numerator;
		float d = (float) denominator;
		return n/d;
	}
	public int simplifyDenominator(int den, int gcd) {
		int x = den/gcd;
		return x;
	}
	
	public int simplifyNumerator(int num, int gcd) {
		int y = num/gcd;
		return y;
	}
	
	public int gcd(int den, int num) {
		while (num != 0) {
			den = num;
			num = den % num;
		}
		System.out.println("GCD is:" +den);
		return den;
	}

}
