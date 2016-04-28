import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * This is a dice game I made for MP6
 * @author Martino Jones
 *
 */
class MP6
{
	static int rolled = 0;
	
	public static void main(String[] args)
	{

		JGraphicDie[] myDieArray = new JGraphicDie[5];
		JGraphicDie[] npcDieArray = new JGraphicDie[5];
		
		//Make the button
		JButton button = new JButton(" >> Click to Roll <<");
		
		//Add action listener to button
        button.setBackground(Color.CYAN);
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)

            {
            	if(rolled < myDieArray.length)
            	{
            		//Roll my dice
            		myDieArray[rolled] = rollDie();
            		
            		
            		//Roll npc dice
            		npcDieArray[rolled] = rollDie();
            		
            		//Display the die
            		displayDie(myDieArray[rolled], npcDieArray[rolled]);
            		
            	}
            	else
            	{
            		//Close all dice windows
            		closeAllDiceWindows();
            		
            		
            		//Display die value
            		System.out.printf("You %10d %10d %10d %10d %10d \nNPC %10d %10d %10d %10d %10d\n",
            				myDieArray[0].getValue(), myDieArray[1].getValue(), myDieArray[2].getValue(), myDieArray[3].getValue(), myDieArray[4].getValue(), 
            				npcDieArray[0].getValue(), npcDieArray[1].getValue(), npcDieArray[2].getValue(), npcDieArray[3].getValue(), npcDieArray[4].getValue());
            		
            		//Find who won
            		int myPair = 0;
            		int npcPair = 0;
            		//Find my pairs
            		Integer[] myNums = new Integer[5];
            		
            		for(int i = 0; i < myDieArray.length; i++)
            		{
            			myNums[i] = myDieArray[i].getValue();
            		}
            		for(int num : findDuplicates(myNums))
            		{
            			myPair++;
            		}
            		
            		//Find npc pairs
            		Integer[] npc = new Integer[5];
            		
            		for(int i = 0; i < npcDieArray.length; i++)
            		{
            			npc[i] = npcDieArray[i].getValue();
            		}
            		for(int num : findDuplicates(npc))
            		{
            			npcPair++;
            		}
            		
            		//Find who won and show their pairs... honestly don't know how the whole pairs thing works
            		if(myPair > npcPair)
            		{
            			System.out.println("You won! You have " + pair(myPair));
            		}
            		else if(myPair == npcPair)
            		{
            			System.out.println("Draw! You both have " + pair(myPair));
            		}
            		else
            		{
            			System.out.println("You lost! the NPC has " + pair(npcPair));
            		}
            		
            		System.exit(0);
            	}
            	
            	rolled++;
            }

        });      
		
		//GraphicDie die = new GraphicDie();
		JFrame frame = new JFrame("button");
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setName("Main");
		frame.getContentPane().add(button);
		frame.setVisible(true);
	
		System.out.println("Lets play a game. Press the button to roll your dice and beat the NPC.");
	}
	
	private static String pair(int myPair)
	{
		switch(myPair)
		{
		case 1:
			return "a pair.";
			
		case 2:
			return "three of a kind.";
			
		case 3:
			return "four of a kind.";
			
		case 4:
			return "five of a kind.";
		}
		return "";
	}
	
	private static JGraphicDie rollDie()
	{
		return new JGraphicDie();
	}
	
	public static Set<Integer> findDuplicates(Integer[] listContainingDuplicates)
	{ 
	  final Set<Integer> setToReturn = new HashSet(); 
	  final Set<Integer> set1 = new HashSet();

	  for (Integer yourInt : listContainingDuplicates)
	  {
	   if (!set1.add(yourInt))
	   {
	    setToReturn.add(yourInt);
	   }
	  }
	  return setToReturn;
	}
	
	private static int[] findMain()
	{
		int[] position = new int[2];
		java.awt.Window win[] = java.awt.Window.getWindows(); 
		for(int i=0;i<win.length;i++){ 
			if(win[i].getName() == "Main")
				position[0] = win[i].getX();
				position[1] = win[i].getY();
			}
		
		return position;
	}
		
	
	private static void closeAllDiceWindows()
	{
		java.awt.Window win[] = java.awt.Window.getWindows(); 
		for(int i=0;i<win.length;i++){ 
			if(win[i].getName() != "Main")
			{
				win[i].dispose();
			}
		}
	}
	
	private static void displayDie(JGraphicDie die, JGraphicDie npc)
	{
		//Close any active dice windows
		closeAllDiceWindows();

		//Get the main window location to place the dice next to it
		int[] main = findMain();
		
		JFrame dieFrame = new JFrame("Your dice");
		JFrame npcFrame = new JFrame("NPC dice");
		
		//Setup the player dice window
		dieFrame.setSize(200, 230);
		dieFrame.add(die);
		dieFrame.setLocation(main[0] + 230, main[1]);
		dieFrame.setVisible(true);
		
		//Setup the nps dice window
		npcFrame.setSize(200, 230);
		npcFrame.add(npc);
		npcFrame.setLocation(main[0] + 432, main[1]);
		npcFrame.setVisible(true);
	}
	
}