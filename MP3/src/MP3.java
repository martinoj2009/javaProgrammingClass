import java.text.DecimalFormat;
import java.util.*;

/**
 * This is MP3
 * @author Martino Jones
 *
 */
class MP3 {
	
	
	public static void main(String[] args) 
	{
		double principle = 1000;
		double rate = 1.5;
		double monthlyPayment = 50;
		int monthsPaid = 0;
		double totalIntrestPaid = 0;
		DecimalFormat Currency = new DecimalFormat("$00.00");
		
		System.out.printf("%3s %8s %9s\n", "Month", "Intrest", "Principle");
		while(principle > 0)
		{
			//If the payments are bellow the interest then you will never be able to pay this off
			//And the program will just be in an infinite look.
			if(monthlyPayment <= (principle * (rate/100)))
			{
				System.out.println("\nYou will never be able to pay this off at that rate.");
				return;
			}
			
			//Add the interest to the principle
			totalIntrestPaid = totalIntrestPaid + (principle * (rate/100));
			System.out.printf("%3d %9s %9s\n", monthsPaid, Currency.format(totalIntrestPaid), Currency.format(principle));
			principle = principle + principle * (rate/100);
			
			//Subtract the monthly payment
			principle = Math.round(principle - monthlyPayment);
			
			//Calculate the months paid
			monthsPaid++;
		}
		
		System.out.println("\nIt will take " + monthsPaid + " months to pay off the loan.");
		System.out.printf("Remaining principle is: $%.2f\n", principle);
		System.out.printf("Total interest paid: $%.2f\n", totalIntrestPaid);
	}
	
	
	
	
	
}