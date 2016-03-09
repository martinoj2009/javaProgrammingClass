import java.util.Scanner;

class JPHD
{
    public static void main(String[] args)
    {
    	//Ignore the warning that the keyboard isn't closed.
    	@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
        
        int beforeBabyBoomers=0;
        int numBabyBoomers=0;
        int numGenX = 0;
        int numMillenials =0;
        int afterMillenials = 0;
        
        int birthYear = 1;
        
        // Note that a birthYear that is 0 or negative gets us out of the loop.
        while (birthYear > 0)
        {
        	System.out.println("Enter a birth year");
            birthYear = keyboard.nextInt();
            
            if(birthYear < 1942)
            {
            	beforeBabyBoomers++;
            }
            
            if((1942 <= birthYear) && (birthYear <= 1964))
            {
            	numBabyBoomers++;
            }
            
            if((1965 <= birthYear) && (birthYear <= 1984))
            {
            	numGenX++;
            }
            
            if((1985 <= birthYear) && (birthYear <= 2004))
            {
            	numMillenials++;
            }
            
            if(birthYear > 2004)
            {
            	afterMillenials++;
            }
            
            System.out.println("before Baby Boomers = " + beforeBabyBoomers);
            System.out.println("number of Baby Boomers = " + numBabyBoomers);
            System.out.println("number of Generation X = " + numGenX);
            System.out.println("number of Millenials = " + numMillenials);
            System.out.println("after  Millenials = " + afterMillenials);
        }
        
        
    }
}