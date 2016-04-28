import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Tester extends JFrame {

	private MyPanel pan = null;
	private Color c = Color.RED;
	private int x = 0, y = 0, w = 0, h = 0;
	
	public Tester()
	{
		super();
		pan = new MyPanel();
		this.add(pan);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Calculator");
		this.pack();
		w = this.getWidth();
		h = this.getHeight();
		
		this.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		while(w >= 0 && h >= 0)
		{
			if (c == Color.RED)
				c = Color.BLUE;
			else
				c = Color.RED;
			
			g.setColor(c);
			g.fillOval(x, y, w, h);
			x += 5;
			y += 5;
			w -= 10;
			h -= 10;
		}
	}
	
	public static void main(String[] args) {
		Tester fr = new Tester();
	}
}