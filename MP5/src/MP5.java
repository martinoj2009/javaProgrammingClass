import java.util.Scanner;
/**
 * This is for MP5
 * @author Martino Jones
 *
 */
class MP5
{
	
	public static void main(String[] args)
	{

		//Initialize a Fraction array of 7 
		Fraction[] fractionArray = new Fraction[7];
		
		int numberOfFractionsProvided = 0;
		Scanner userInput = new Scanner(System.in);
		
		
		System.out.println("Please give me 7 fractions. Example: 1/2");
		
		//While the user hasn't provided 7 fractions keep asking for fractions
		while(numberOfFractionsProvided < fractionArray.length)
		{
			System.out.print("Provide fraction " + ((int)numberOfFractionsProvided+1) + ": ");
			
			String userFraction = userInput.nextLine();
			
			//As long as what the user provided is a fraction continue, else repeat look
			if(checkInput(userFraction))
			{
				fractionArray[numberOfFractionsProvided] = new Fraction(userFraction);
				numberOfFractionsProvided++;
			}

		}
		
		//Close the Scanner, no longer needed.
		userInput.close();
		
		//Make new array of sorted fractions and pass to BubbleSort method
		Fraction[] sortedFractions = BubbleSort(fractionArray);
		
		
		//Move all fractions except for the first and last fractions back
		for(int i = 0; i < sortedFractions.length; i++)
		{
			if(i < sortedFractions.length-2)
			{
				fractionArray[i] = sortedFractions[i+1];
			}
			else
			{
				//Null out the last two
				fractionArray[i] = null;
			}
		}
		
		//Null sortedFractions array, no longer needed
		sortedFractions = null;
		
		
		//Using the last index in the array as the sum, iterate over the array-2 and add 
		//to the last index of the array and assign to the last index.
		for(int i = 0; i < fractionArray.length-2; i++)
		{
			if(i == 0)
			{
				//Store the first object in the array in the last
				fractionArray[fractionArray.length-1] = fractionArray[i];
			}
			else
			{
				//Add the current index in the array to the last index and store in the last index
				fractionArray[fractionArray.length-1] = fractionArray[i].add(fractionArray[fractionArray.length-1]);
			}
		}
		
		//Print out the answer
		for(int i = 0; i < fractionArray.length-2; i++)
		{
			System.out.print(fractionArray[i].toString() + " + ");
		}
		System.out.println("= "+ fractionArray[fractionArray.length-1]);
	}
	
	/**
	 * This is a Bubble Sort method. Pass in a Fraction[] Object and it will sort the
	 * objects by their ratio. The objects need getRatio method.
	 * @param userFraction Fraction[] Object
	 * @return Fraction[] Object
	 */
	public static Fraction[] BubbleSort(Fraction[] userFraction)
	{
		boolean flag = true;  //flag saying if it has swapped
		Fraction tempHolding;  //Temp hold the object
		
		while(flag)
		{
			flag = false;
			
			for(int i = 0; i < userFraction.length-1; i++)
			{
				if(userFraction[i].getRatio_value() > userFraction[i+1].getRatio_value())
				{
					tempHolding = userFraction[i];
					userFraction[i] = userFraction[i+1];
					userFraction[i+1] = tempHolding;
					flag = true;
				}
			}
		}
		
		return userFraction;
	}
	
	/**
	 * This method is for checking user input. Make sure it's in fraction form and
	 * contains numbers for the numerator and denominator. Also make sure the numerator isn't
	 * bigger than the denominator.
	 * @param input String
	 * @return True for passed. False for failed. 
	 */
	private static boolean checkInput(String input)
	{
		int num1;
		int num2;
		if(input.contains("/"))
		{
			//Test the numerator
			try
			{
				num1 = Integer.parseInt(input.split("/")[0]);
			}
			catch(Exception ex)
			{
				System.out.println("The numerator provided is not a number");
				return false;
			}
			
			//Now set the denominator
			try
			{
				num2 = Integer.parseInt(input.split("/")[1]);
			}
			catch(Exception ex)
			{
				System.out.println("The denominator provided is not a number");
				return false;
			}
		}
		else
		{
			System.out.println("You need to enter a fraction with a \"/\". Example: 1/2");
			return false;
		}
		
		//make sure the numerator isn't bigger than the denominator
		if(num1 > num2)
		{
			System.out.println("The numerator can't be bigger than the denominator. This program doesn't handle improper fractions.");
			return false;
		}
		
		//Everything passed
		return true;
	}
}