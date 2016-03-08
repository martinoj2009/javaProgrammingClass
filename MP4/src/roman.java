
import java.util.*;

/**
 * This is a class that will handle Roman numeral calculations
 * @author Martino Jones
 *
 */
public class roman {
	
	private int myIntValue;
	private String myRomanValue;
	
 	roman()
	{
		myIntValue = 0;
		myRomanValue = "";
	}
	
	//Constructor overrides
	
	roman(String romanValue)
	{
		myRomanValue = romanValue;
		myIntValue = convert_From_Roman(romanValue);
	}
	
	roman(int intValue)
	{
		myIntValue = intValue;
		myRomanValue = convert_To_Roman(intValue);
	}
	
	
	//Private methods
	
	private int romanCharToInt(char romanChar)
	{
		switch(romanChar)
		{
		case 'I':
			return 1;
			
		case 'V':
			return 5;
		
		case 'X':
			return 10;
			
		case 'L':
			return 50;
		
		case 'C':
			return 100;
			
		case 'D':
			return 500;
			
		case 'M':
			return 1000;
			
		default:
			return 0;
		
		
		}
	}
	
	private String convert_To_Roman(int myInt)
	{
		String newRoman = "";
		while(myInt > 0)
		{
			//subtract 1000 until less than 1000
			while(myInt >= 1000)
			{
				myInt = myInt - 1000;
				newRoman = newRoman + "M";
			}
			
			//Subtract 500 until less than 500
			while(myInt >= 500)
			{
				myInt = myInt - 500;
				newRoman = newRoman + "D";
			}
			
			//Subtract 100 until less than 100
			while(myInt >= 100)
			{
				myInt = myInt - 100;
				newRoman = newRoman + "C";
			}
			
			//Subtract 50 until less than 50
			while(myInt >= 50)
			{
				myInt = myInt - 50;
				newRoman = newRoman + "L";
			}
			
			//Subtract 10 until less than 10
			while(myInt >= 10)
			{
				myInt = myInt - 10;
				newRoman = newRoman + "X";
			}
			
			//Subtract 5 until less than 5
			while(myInt >= 5)
			{
				myInt = myInt - 5;
				newRoman = newRoman + "V";
			}
			
			//Subtract 1 until less than 1
			while(myInt >= 1)
			{
				myInt = myInt - 1;
				newRoman = newRoman + "I";
			}
		}
		
		//Return the new Roman value
		return newRoman;
	}
	
	private int convert_From_Roman(String romanValue)
	{
		int newValue = 0;
		
		//This list will be used to iterate the String
		List<Character> charList = new ArrayList<Character>();
		
		//Add each uppercase character to the list
		for(char c : romanValue.toUpperCase().toCharArray())
		{
			charList.add(c);
		}
		
		//Iterate over the list to add all the characters up
		for(int i = 0; i < charList.size(); i++)
		{
			newValue = newValue + romanCharToInt(charList.get(i));
		}
		
		
		
		return newValue;
	}

	
	
	//Public methods
	
	public int get_Int()
	{
		return myIntValue;
	}
	
	public String get_Roman()
	{
		return myRomanValue;
	}
	
	public void print_Result()
	{
		System.out.println("Decimal value is: " + myIntValue);
		System.out.println("Roman value is: " + myRomanValue);
	}
	
	public boolean calc_Romans(int firstInt, int secondInt, char operator)
	{
		switch(operator)
		{
		case '+':
			myIntValue = firstInt + secondInt;
			return false;
			
		case '-':
			myIntValue = firstInt - secondInt;
			return false;
			
		case '*':
			myIntValue = firstInt * secondInt;
			return false;
			
		case '/':
			myIntValue = firstInt / secondInt;
			return false;
			
		default:
			System.out.println(operator + " is an invalid operator.");
			return true;

		}
	}
	
	/**
	 * This method will accept a string, it will then check the 
	 * string to make sure there's no invalid characters and print the results.
	 * @param data
	 * @return
	 */
	public boolean get_Data(String data)
	{
		//Convert all characters to upper
		data = data.toUpperCase();
		
		//Build the lists needed
		List<Character> validCharacters = new ArrayList<Character>(Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M', '/', '*', '-', '+', ' '));
		List<Character> charList = new ArrayList<Character>();
		
		
		//Add data provided to the list
		for(char c : data.toCharArray())
		{
			charList.add(c);
		}
		
		//Check each character in string to make sure it's valid
		for(char c : charList)
		{
			if(!validCharacters.contains(c))
			{
				System.out.println("The caracter: "  + c + " is not a valid character!");
				return true;
			}
		}
		
		
		//Get the results of the calculation
		try
		{
			//Perform the calculations and return true if an error occurs
			if(calc_Romans(convert_From_Roman(data.split(" ")[0]), convert_From_Roman(data.split(" ")[1]), data.split(" ")[2].charAt(0)))
			{
				return true;
			}
			
			//Print the results
			System.out.println("The first number is " + data.split(" ")[0] + " ( " + convert_From_Roman(data.split(" ")[0]) + " )");
			System.out.println("The second number is " + data.split(" ")[1] + " ( " + convert_From_Roman(data.split(" ")[1]) + " )");
			System.out.println("The operator is " + data.split(" ")[2].charAt(0));
			System.out.println("The result is " + myIntValue + "( " + convert_To_Roman(myIntValue) + " )");
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Please make sure you include spaces. Ex: M M +");
		}
		
		
		return false;
	}
}
