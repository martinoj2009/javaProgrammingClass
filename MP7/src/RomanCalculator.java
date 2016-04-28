import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class RomanCalculator
{

	
	
	public int convert_From_Roman(String romanValue)
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
	
	public String convert_To_Roman(int myInt)
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
	
	
}