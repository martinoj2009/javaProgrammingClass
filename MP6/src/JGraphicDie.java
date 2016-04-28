import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

class JGraphicDie extends JPanel
{
	private int value;
	private GraphicDie die = new GraphicDie();
	
	JGraphicDie()
	{
		value = die.getValue();
	}
	
	
	public void paintComponent(Graphics g)
	{
		
		
		die.drawDie(g, 200, 200, die.getValue());

	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}