import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
class ButtonAction implements ActionListener
{

	private JButton position;
	private JButton[] positions;
	
	ButtonAction(JButton pos, JButton[] poss)
	{
		position = pos;
		positions = poss;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(position.getText().toUpperCase() != "X" || position.getText().toUpperCase() != "O")
		{
			position.setText("X");
		}
		checkWin(positions);
	}
	
	private boolean checkWin(JButton[] pos)
	{
		
		int[] win1 = new int[] {0,1,2};
		int[] win2 = new int[] {3,4,5};
		int[] win3 = new int[] {6,7,8};
		int[] win4 = new int[] {0,3,6};
		int[] win5 = new int[] {1,4,7};
		int[] win6 = new int[] {2,5,8};
		int[] win7 = new int[] {0,4,8};
		
		int num = 0;
		
		//Check win1
		for(int i = 0; i < win1.length; i++)
		{
			if(pos[win1[i]].getText() == "X")
			{
				num++;
			}
		}
		
		if(num == 3)
		{
			System.out.println("Win");
			return true;
		}
		else
		{
			num = 0;
		}

		//Check win2
		for(int i = 0; i < win2.length; i++)
		{
			if(pos[win2[i]].getText() == "X")
			{
				num++;
			}
		}
		
		if(num == 3)
		{
			System.out.println("Win");
			return true;
		}
		else
		{
			num = 0;
		}
		
		//Check win3
		for(int i = 0; i < win3.length; i++)
		{
			//System.out.println(pos[win3[i]].getText());
			try
			{
				if(pos[win3[i]].getText() == "X")
				{
					num++;
				}
			}
			catch(Exception ex)
			{
				
			}
			
		}
		
		if(num == 3)
		{
			System.out.println("Win");
			return true;
		}
		else
		{
			num = 0;
		}
		
		//Check win4
		for(int i = 0; i < win4.length; i++)
		{
			try
			{
				if(pos[win4[i]].getText() == "X")
				{
					num++;
				}
			}
			catch(Exception ex)
			{
				
			}
			
		}
		
		if(num == 3)
		{
			System.out.println("Win");
			return true;
		}
		else
		{
			num = 0;
		}
		
		
		//Check win5
		for(int i = 0; i < win5.length; i++)
		{
			try
			{
				if(pos[win5[i]].getText() == "X")
				{
					num++;
				}
			}
			catch(Exception ex)
			{
				
			}
			
		}
		
		if(num == 3)
		{
			System.out.println("Win");
			return true;
		}
		else
		{
			num = 0;
		}
		
		//Check win6
		for(int i = 0; i < win6.length; i++)
		{
			try
			{
				if(pos[win6[i]].getText() == "X")
				{
					num++;
				}
			}
			catch(Exception ex)
			{
				
			}
			
		}
		
		if(num == 3)
		{
			System.out.println("Win");
			return true;
		}
		else
		{
			num = 0;
		}
		
		//Check win7
		for(int i = 0; i < win7.length; i++)
		{
			try
			{
				if(pos[win7[i]].getText() == "X")
				{
					num++;
				}
			}
			catch(Exception ex)
			{
				
			}
			
		}
		
		if(num == 3)
		{
			System.out.println("Win");
			return true;
		}
		else
		{
			num = 0;
		}
		
		return false;
	}
	
}