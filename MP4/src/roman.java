import java.util.ArrayList;
import java.util.List;


/**
 * This is a class that will handle Roman numeral calculations
 * @author Martino Jones
 *
 */
public class roman {
	
	private int myIntValue;
	
 	roman()
	{
		myIntValue = 0;
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
	
	/**
	 * This method is for converting from Roman characters to a number.
	 * The method will add all the Roman characters up and return an integer.
	 * This method needs the romanCharToInt method for converting the ASCII char to a number
	 * so that I can perform the addition.
	 * @param romanValue - Must be a string to be converted to an integer later.
	 * @return This method returns the integer of the added Roman numerals.
	 */
	private int convert_From_Roman(String romanValue)
	{
		
		int newValue = 0;
		
		//This list will be used to iterate the String
		List<Character> charList = new ArrayList<Character>();
		
		//Add each upper-case character to the list
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
	
	
	/**
	 * This method is for performing the calculations. It accepts two integers and a char, the char 
	 * needs to be the mathematical operation to be performed. This is private and is only needed internally.
	 * If an invalid operator is passed then it will print a message saying so and break the switch.
	 * @param firstInt 
	 * @param secondInt
	 * @param operator - This is a char and needs to be: / * - +
	 * @return This function returns an in.
	 */
	private boolean calc_Romans(int firstInt, int secondInt, char operator)
	{
		
		//Check the operator and perform the mathematical function associated. If one isn't found then assume it's invalid.
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
			//The operator is invalid, print the operator and a message saying it's invalid and return true, meaning an error occurred
			System.out.println(operator + " is an invalid operator.");
			return true;

		}
	}
	
	
	//Public methods
	
	/**
	 * This method will accept a string, it will then check the 
	 * string to make sure there's no invalid characters and print the results.
	 * @param data
	 * @return
	 */
	public boolean get_Data(String data)
	{
		String firstRoman = "";
		String secondRoman = "";
		char operator = ' ';
		
		//Convert all characters to upper
		data = data.toUpperCase();
		
		//Build the lists needed
		//This char array is all the valid characters that should be accepted from the user.
		char[] validCharacters = new char[] {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		
		//This list will be a list of the chars in the string the user passed in
		List<Character> charList = new ArrayList<Character>();
		
		
		//Add data provided to the list
		for(char c : data.toCharArray())
		{
			charList.add(c);
		}

		
		//Trim whitespace at the beginning
		data = data.trim();
		
		//Check to make sure data isn't blank
		if(data.length() < 1)
		{
			System.out.println("This line is blank.");
			return true;
		}
		
		//Pull the first Roman characters out of the string
		for(int i = 0; i < data.length(); i++)
		{
			//As long as it's not a space append char to string
			if(data.charAt(i) != ' ')
			{
				firstRoman = firstRoman + data.charAt(i);
			}
			else
			{
				//Delete the chars I've processed so far and break
				data = data.substring(i - -1);
				break;
			}
		}
		
		//Make sure the first Roman number has valid characters
		for(char c : firstRoman.toCharArray())
		{
			if(!(new String(validCharacters).contains(Character.toString(c))))
			{
				System.out.println(firstRoman + " is an invalid Roman numeral.");
				return true;
			}
		}
		
		
		//Trim whitespace at the beginning
		data = data.trim();
		
		//Check if the data is blank and inform the user no second Roman numeral was provided
		if(data.length() < 1)
		{
			System.out.println("No second Roman numeral provided.");
			return true;
		}
		
		//Now we need the second Roman number
		for(int i = 0; i < data.length(); i++)
		{
			//As long as it's not a space append char to string
			if(data.charAt(i) != ' ')
			{
				secondRoman = secondRoman + data.charAt(i);
			}
			else
			{
				//Delete the chars I've processed so far and break
				data = data.substring(i - -1);
				break;
			}
		}
		
		//Make sure the second Roman number has valid characters
		for(char c : secondRoman.toCharArray())
		{
			if(!(new String(validCharacters).contains(Character.toString(c))))
			{
				System.out.println(secondRoman + " is an invalid Roman numeral.");
				return true;
			}
		}
		
		
		//Finally we need the operator
		data = data.trim();
		try
		{
			operator = data.charAt(0);
		}
		catch(StringIndexOutOfBoundsException ex)
		{
			System.out.println("Was unable to find the operator.");
			return true;
		}
		

		
		
		//Get the results of the calculation
		try
		{
			//Perform the calculations and return true if an error occurs
			if(calc_Romans(convert_From_Roman(firstRoman.trim()), convert_From_Roman(secondRoman.trim()), operator))
			{
				return true;
			}
			
			//Print the results of all my hard work.
			System.out.println("The first number is " + firstRoman + " ( " + convert_From_Roman(firstRoman) + " )");
			System.out.println("The second number is " + secondRoman + " ( " + convert_From_Roman(secondRoman) + " )");
			System.out.println("The operator is " + operator);
			System.out.println("The result is " + myIntValue + "( " + convert_To_Roman(myIntValue) + " )");
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Please make sure you include spaces. Example: M M +");
			return true;
		}
		catch(Exception ex)
		{
			//Something else happened that I didn't account for. Catch that and tell the user how to format the input.
			System.out.println("Example of input: M M +");
			return true;
			
		}
		
		//Everything ran good, return false.
		return false;
	}

}
