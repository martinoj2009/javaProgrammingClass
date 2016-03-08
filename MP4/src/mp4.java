import java.util.Scanner;

class mp4 
{
	
	public static void main(String[] args)
	{
		roman calculator = new roman();
		Scanner userInput = new Scanner(System.in);
		String userData = "";
		
		
		while(true)
		{
			System.out.println("Please provide two roman numbers seperated by spaces, then another space and the operation to perform.");
			userData = userInput.nextLine();
			if(calculator.get_Data(userData))
			{
				
			}
			
			System.out.println("************************************************");
			
		}
		
	}
	
	
}