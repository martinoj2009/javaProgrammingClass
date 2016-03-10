import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * MP4 project
 * @author Martino Jones
 *
 */
class mp4 
{
	
	public static void main(String[] args)
	{
		//Initialize the class as the calculator object 
		roman calculator = new roman();
		
		//Read in the file
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream("input");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//The try catch above will 
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String strLine;
		
		//Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null)   
			{
			  // Print the content on the console
				calculator.get_Data(strLine);
				System.out.println("******************************************************************************************************");
			}
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}