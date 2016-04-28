/**
 * This is a Fraction object for storing numerator and denominator and calculating. 
 * @author Martino Jones
 *
 */
class Fraction
{
	
	
	private int numerator;
	private int denominator;
	private double ratio_value;
	
	Fraction()
	{
		numerator = 0;
		denominator = 0;
		ratio_value = 0;
	}
	
	//Overloads
	Fraction(int num, int denom)
	{
		numerator = num;
		denominator = denom;
		ratio_value = numerator/denominator;
	}
	
	Fraction(String ratio)
	{
		if(ratio.contains("/"))
		{
			try
			{
				numerator = Integer.parseInt(ratio.split("/")[0]);
			}
			catch(Exception ex)
			{
				System.out.println("The numerator provided is not a number");
			}
			
			//Now set the denominator
			try
			{
				denominator = Integer.parseInt(ratio.split("/")[1]);
			}
			catch(Exception ex)
			{
				System.out.println("The denominator provided is not a number");
			}
			
			ratio_value = (double)numerator / (double)denominator;
		}
		else
		{
			System.out.println("You need to enter a fraction using /");
			numerator = 0;
			denominator = 0;
			ratio_value = 0;
			
			return;
		}
	}
	
	//Mutators
	public int getNumerator() {
		return numerator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
		ratio_value = (double)numerator / (double)denominator;
	}
	public int getDenominator() {
		return denominator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
		ratio_value = (double)numerator / (double)denominator;
	}
	public double getRatio_value() {
		return ratio_value;
	}
	public void setRatio_value(double ratio_value) {
		this.ratio_value = ratio_value;
	}
	
	//Public methods
	
	/**
	 * This method is for reducing the fraction of the current object.
	 * The fraction will be returned with reducedNumerator + "/" + reducedDenominator.
	 * @return String 
	 */
	public String reduce()
	{
		int reducedNumerator;
		int reducedDenominator;
		
		reducedNumerator = numerator / gcd(numerator, denominator);
		reducedDenominator = denominator / gcd(numerator, denominator);
		return reducedNumerator + "/" + reducedDenominator;
	}
	
	/**
	 * This method overrides the toString so that I can get the String version of the Fraction Object.
	 * Will return numerator + "/" + denominator.
	 * @return String
	 */
	public String toString()
	{
		
		return numerator + "/" + denominator;
	}
	
	/**
	 * This will add two Fraction Objects together. You must pass in a Fraction Object that contains the following public methods:
	 * getNumerator, getDenominator. This method needs a gcd method.
	 * @param userFraction Fraction Object
	 * @return Fraction Object
	 */
	public Fraction add(Fraction userFraction)
	{
		Fraction answer;
		
		if(denominator == userFraction.getDenominator())
		{
			answer = new Fraction(userFraction.getNumerator() + numerator, denominator);
		}
		else
		{
			int newNumerator = ((userFraction.numerator*denominator) +
		            (numerator*userFraction.denominator));
		    int newDenominator = denominator*userFraction.denominator;

		    int gcd = gcd(newNumerator, newDenominator);
		    
		    newNumerator = newNumerator/gcd;
		    newDenominator = newDenominator/gcd;
		    
		    answer = new Fraction (newNumerator, newDenominator);
		}
		
		return answer;
	}
	
	//Private methods
	
	/**
	 *  This method will calculate the Greatest Common Divisor of two integers passed in
	 * @param num1
	 * @param num2
	 * @return
	 */
	private int gcd(int num1, int num2)
	{
		while (num2 > 0)
	    {
	        int temp = num2;
	        num2 = num1 % num2; // % is remainder
	        num1 = temp;
	    }
	    return num1;
	}
	

}