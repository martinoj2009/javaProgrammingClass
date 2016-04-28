import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class ExtraC
{
	//Valid characters
	static char[] validChars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
	
	public static void main(String[] args)
	{
		String signs = "XO";
		Random r = new Random();
		
		//Create array of positions
		boardPosition[] positions = new boardPosition[9];
		char letter = 'a';
		
		//Fill object array with positions
		for(int i = 0; i < positions.length; i++)
		{
			positions[i] = new boardPosition(letter);
			letter++;
		}
		
		
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		
		//Sets the users sign
		char userSign = signs.charAt(r.nextInt(signs.length()));
		
		//Set the npc sign
		if(userSign == 'X')
		{
			char npcSign = 'O';
		}
		else
		{
			char npcSign = 'x';
		}
		
		//Loop for the game
		while(!checkDone(positions))
		{
			printBoard(positions);
			System.out.print("Player1. Sign:" + userSign + ": ");
			char input = userInput.next().toLowerCase().charAt(0);
			if(checkInput(input))
			{
				setPosition(positions, input, userSign);
				if(checkWin(positions) == true)
				{
					System.out.println("Done!");
				}
			}
			else
			{
				System.out.println("That's not a valid position. Eneter a letter between a and i.");
			}
			
		}
		
	}
	
	private static boardPosition[] npcTurn(boardPosition[] positions, char npcSign)
	{
		ArrayList<boardPosition> availablePositions = new ArrayList<boardPosition>();
		boardPosition[] newBoard = positions;
		
		//Get the positions available
		for(boardPosition position : positions)
		{
			if(position.isUsed() == ' ')
			{
				availablePositions.add(position);
			}
		}
		
		//pick a board position
		
		return newBoard;
	}
	
	private static boardPosition[] setPosition(boardPosition[] positions, char position, char userSign)
	{
		boardPosition[] newBoard = positions;
		
		for(int i = 0; i < newBoard.length; i++)
		{
			if(newBoard[i].getPosition() == position)
			{
				if(newBoard[i].isUsed() == ' ')
				{
					newBoard[i].setUsed(true);
					newBoard[i].setUserSign(userSign);
				}
				else
				{
					System.out.println("That position is taken.");
				}
			}
		}
		
		return newBoard;
	}
	private static void printBoard(boardPosition[] positions)
	{
		//Print the board
				System.out.printf("----%c-------%c-------%c----\n"
						+ "|  %c    |  %c    |  %c    |\n"
						+ "----%c-------%c-------%c----\n"
						+ "|  %c    |  %c    |  %c    |\n"
						+ "----%c-------%c-------%c----\n"
						+ "|  %c    |  %c    |  %c    |\n"
						+ "------------------------\n"
						+ "===============================e\n", 
						positions[0].getPosition(), positions[1].getPosition(), positions[2].getPosition(), 
						positions[0].isUsed(), positions[1].isUsed(), positions[2].isUsed(), 
						positions[3].getPosition(), positions[4].getPosition(), positions[5].getPosition(), 
						positions[3].isUsed(), positions[4].isUsed(), positions[5].isUsed(), 
						positions[6].getPosition(), positions[7].getPosition(), positions[8].getPosition(), 
						positions[6].isUsed(), positions[7].isUsed(), positions[8].isUsed());
	}
	
	
	private static boolean checkDone(boardPosition[] positions)
	{
		int numDone = 0;
		for(int i = 0; i < positions.length; i++)
		{
			if(positions[i].isUsed() == 'X')
			{
				numDone++;
			}
		}
		
		if(numDone >= positions.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private static boolean checkInput(char input)
	{
		for(int i = 0; i < validChars.length; i++)
		{
			if(input == validChars[i])
				return true;
		}
		
		return false;
	}
	
	private static boolean checkWin(boardPosition[] positions)
	{
		ArrayList<Character[]> cList = new ArrayList<Character[]>();
		cList.add(new Character[] {'a','b','c'});
		cList.add(new Character[] {'d','e','f'});
		cList.add(new Character[] {'g','h','i'});
		cList.add(new Character[] {'a','d','g'});
		cList.add(new Character[] {'b','e','h'});
		cList.add(new Character[] {'c','f','i'});
		cList.add(new Character[] {'a','e','i'});

		int combs = 0;
		
		for(boardPosition position : positions)
		{
			if(position.isUsed() != ' ')
			{
				
				for(Character[] letter : cList)
				{
					for(int i = 0; i < letter.length; i++)
					{
						if(letter[i] == position.getPosition())
						{
							System.out.println(letter[i]);
							combs++;
							System.out.println(combs);
						}
					}
					
					if(combs == 3)
					{
						return true;
					}
					else
					{
						combs = 0;
					}
				}
			}
		}
		
		return false;
	}
}