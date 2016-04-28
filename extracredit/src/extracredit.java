import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class extracredit extends Frame
{
	
	public static void main(String[] args)
	{
		
		
		//Position buttons
		JButton[] position = new JButton[9];
		for(int i = 0; i < position.length; i++)
		{
			position[i] = new JButton("");
			position[i].setName(Integer.toString(i));
		}
		
		
		//Action listeners
		for(int i = 0; i < position.length; i++)
		{
			position[i].addActionListener(new ButtonAction(position[i], position));
		}
		
		
		
		
		//Layout
		GridLayout main = new GridLayout(1, 3);
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(3,3)); 
		for(int i = 0; i < position.length; i++)
		{
			topPanel.add(position[i]);
		}

		
		//JFrame
		JFrame frame = new JFrame("Calculator");
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 400);
		frame.setName("Main");
		frame.setLayout(main);
		frame.add(topPanel);
		frame.setVisible(true);
	}
	
	
	
	
	
}