import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
/**
 * This is an action listener. Needs ActionListner
 * @author Martino Jones
 *
 */
class ButtonAction implements ActionListener
{

	ArrayList<JTextField> textBoxes = new ArrayList<JTextField>();
	private JButton button1;
	//Make Roman calculator
	private RomanCalculator rCalc = new RomanCalculator();
	
	/**
	 * This constructor needs a button and two text boxes for doing actions on 
	 * two text boxes after a button click.
	 * @param btn 
	 * @param tf1
	 * @param tf2
	 */
	ButtonAction(JButton btn, JTextField tf1, JTextField tf2)
	{
		textBoxes.add(tf1);
		textBoxes.add(tf2);
		button1 = btn;
	}
	
	
	
	@Override
	/**
	 * If the textbox is red, then perform the action the button says
	 */
	public void actionPerformed(ActionEvent arg0) {
		for(JTextField text : textBoxes)
		{
			if(text.getBackground() == Color.RED)
			{
				//This will convert the Roman numerals of the button and text box together, then convert them back to Roman
				//numerals so that it can use the least amount of characters
				text.setText(rCalc.convert_To_Roman(rCalc.convert_From_Roman(text.getText() + button1.getName())));
			}
		}
		
	}
	
	
	
	
	
}