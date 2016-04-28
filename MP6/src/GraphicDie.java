import java.awt.Color;
import java.awt.Graphics;
import java.awt.RenderingHints;

class GraphicDie extends Die
{
	
	GraphicDie()
	{
		super();
	}
	
	public void drawDie(Graphics g, int x, int y, int num)
	{
		int w=x;int h=y;
		int r = 5;
		
		switch(num)
		{
		case 1:
			  
			  g.setColor(new Color(128,128,128));
			  g.fillRect(0,0,w,h);
			  g.setColor(new Color(255,64,64));
			  g.setColor(Color.red);
			  g.fillOval(w/2-r,h/2-r,2*r,2*r); 
			  g.setColor(Color.black);
			  g.drawOval(w/2-r,h/2-r,2*r,2*r);
			break;
			
		case 2:
			  g.setColor(new Color(128,128,128));
			  g.setColor(Color.red); 
			  g.fillOval(w/4-r,h/4-r,2*r,2*r);
			  g.fillOval(150-r,150-r,2*r,2*r);
			  g.setColor(Color.black);
			  g.drawOval(w/4-r,h/4-r,2*r,2*r);
			  g.drawOval(150-r,150-r,2*r,2*r);;
			  break;
		
		case 3:
			  g.setColor(new Color(128,128,128));
			  g.setColor(Color.red); 
			  g.fillOval(w/4-r,h/4-r,2*r,2*r);
			  g.fillOval(100-r,100-r,2*r,2*r);
			  g.fillOval(156-r,156-r,2*r,2*r);
			  g.setColor(Color.black);
			  g.drawOval(w/4-r,h/4-r,2*r,2*r);
			  g.drawOval(156-r,156-r,2*r,2*r);
			  g.drawOval(100-r,100-r,2*r,2*r);
			  break;
			  
		case 4:
			g.setColor(new Color(128,128,128));
			  g.setColor(Color.red); 
			  g.fillOval(1,5,2*r,2*r);
			  g.fillOval(150,5,2*r,2*r);
			  g.fillOval(1,150,2*r,2*r);
			  g.fillOval(150,150,2*r,2*r);
			  g.setColor(Color.black);
			  g.drawOval(150,5,2*r,2*r);
			  g.drawOval(1,5,2*r,2*r);
			  g.drawOval(1,150,2*r,2*r);
			  g.drawOval(150,150,2*r,2*r);
			  break;
			  
		case 5:
			  g.setColor(new Color(128,128,128));
			  g.setColor(Color.red); 
			  g.fillOval(1,5,2*r,2*r);
			  g.fillOval(150,5,2*r,2*r);
			  g.fillOval(1,150,2*r,2*r);
			  g.fillOval(150,150,2*r,2*r);
			  g.fillOval(75,75,2*r,2*r);
			  g.setColor(Color.black);
			  g.drawOval(150,5,2*r,2*r);
			  g.drawOval(1,5,2*r,2*r);
			  g.drawOval(1,150,2*r,2*r);
			  g.drawOval(150,150,2*r,2*r);
			  g.drawOval(75,75,2*r,2*r);
			  break;
			  
		case 6:
			  g.setColor(new Color(128,128,128));
			  g.setColor(Color.red); 
			  g.fillOval(1,1,2*r,2*r);
			  g.fillOval(1,75,2*r,2*r);
			  g.fillOval(1,150,2*r,2*r);
			  g.fillOval(150,1,2*r,2*r);
			  g.fillOval(150,75,2*r,2*r);
			  g.fillOval(150,150,2*r,2*r);
			  g.setColor(Color.black);
			  g.drawOval(1,1,2*r,2*r);
			  g.drawOval(1,75,2*r,2*r);
			  g.drawOval(1,150,2*r,2*r);
			  g.drawOval(150,1,2*r,2*r);
			  g.drawOval(150,75,2*r,2*r);
			  g.drawOval(150,150,2*r,2*r);
			  break;
		}
			  
	}
	
	
	
	
	
	
	
	
}