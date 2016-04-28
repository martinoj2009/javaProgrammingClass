import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

/**
 * This is a mouse action listener for mouse clicks.
 * @author Martino Jones
 *
 */
class MouseClick implements MouseListener
{

	private JTextField textField1;
	
	/**
	 * This constructor will accept one textbox to work on.
	 * @param t
	 */
	MouseClick(JTextField t)
	{
		textField1 = t;
	}
	
	
	@Override
	/**
	 * This action will set the background of the button to red if it's not.
	 * If the background of the button is red the background will be set to null.
	 */
	public void mouseClicked(MouseEvent e) {
		//Right click to clear the field
		if(e.getButton() == 3)
		{
			textField1.setText(null);
			return;
		}
		
		if(textField1.getBackground() == Color.RED)
		{
			this.textField1.setBackground(null);
		}
		else
		{
			this.textField1.setBackground(Color.RED);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}