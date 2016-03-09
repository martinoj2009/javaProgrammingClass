import java.util.Scanner;

/**
 * MP4
 * @author Martino Jones
 *
 */
class mp4 
{
	
	public static void main(String[] args)
	{
		roman calculator = new roman();
		
		//Suppress the warning of not closing the scanner
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		String userData = "";
		
		//Infinite loop for asking the user for input
		while(true)
		{
			System.out.println("Please provide two roman numbers seperated by spaces, then another space and the operation to perform.");
			userData = userInput.nextLine();
			
			
			//Pass the user provided data into the get_Data method and check for error (true)
			if(calculator.get_Data(userData))
			{
				
			}
			
			//This will make the printout a lot more readable. It's this long to encapsulate some of the error messages
			System.out.println("******************************************************************************************************");
			
		}
		
	}
	
	
}