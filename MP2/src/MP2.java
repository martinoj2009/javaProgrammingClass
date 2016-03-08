import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

class MP2 {
	
	
	public static void main(String[] args)
	{
		PrintWriter write = null;
		//Open statement as append
		try {
			write = new PrintWriter(new FileOutputStream(new File("statement.txt"),true));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(-1);
		}
		
		//Make the file object and open transactions.txt
		String fileIn = "transactions.txt";
		
		Scanner readInFile = null;
		try
		{
			readInFile = new Scanner(Paths.get(fileIn));
		}
		catch(IOException e)
		{
			System.out.println("Error, file wasn't found!");
			System.exit(-1);
		}
		
		while(readInFile.hasNextLine())
		{
			String currentLine = readInFile.nextLine();
			
			String customerName = currentLine.split(",")[0];
			double accountBalance = Double.parseDouble(currentLine.split(",")[1].split(" ")[1]);
			char transactionType = currentLine.split(",")[1].split(" ")[2].toUpperCase().charAt(0);
			double transactionAmount = Double.parseDouble(currentLine.split(",")[1].split(" ")[3]);
			double newAccountBalance;
			
			//Perform the transaction by the type of transaction
			switch(transactionType)
			{
			case 'D':
				newAccountBalance = accountBalance + transactionAmount;
				break;
			case 'W':
				newAccountBalance = accountBalance - transactionAmount;
				break;
			default:
				newAccountBalance = accountBalance;
			}
			
			
			System.out.println("Customer Name: " + customerName);
			write.println("Customer Name: " + customerName);
			
			System.out.printf("Checking balance before transaction: $%.2f\n", accountBalance);
			write.printf("Checking balance before transaction: $%.2f\n", accountBalance);
			
			System.out.println("Transaction Type: " + transactionType);
			write.println("Transaction Type: " + transactionType);
			
			System.out.printf("Transaction amount: $%.2f\n", transactionAmount);
			write.printf("Transaction amount: $%.2f\n", transactionAmount);
			
			//Don't print a balance after transaction if it was just a report.
			if(transactionType != 'R')
			{
				System.out.printf("Checking balance after transaction: $%.2f\n", newAccountBalance);
				write.printf("Checking balance after transaction: $%.2f\n", newAccountBalance);
			}
			
			//Print message if below $300
			if(newAccountBalance < 300)
			{
				System.out.println("Warning: The account is below $300.");
				write.println("Warning: The account is below $300.");
			}
			
			System.out.println("­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­---------------------------------------------");
			write.println("­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­---------------------------------------------");
		}
	    
	    write.close();
	}
	
	
}