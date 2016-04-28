import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class RomanTextAction implements DocumentListener
{

	private JTextField roman;
	private JTextField num;
	//Make Roman calculator
	private RomanCalculator rCalc = new RomanCalculator();
	private boolean reverse;
		
	RomanTextAction(JTextField rom, JTextField inte, boolean rev)
	{

		roman = rom;
		num = inte;
		reverse = rev;

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if(reverse == false)
		{
			num.setText(Integer.toString(rCalc.convert_From_Roman(roman.getText())));
		}
		else
		{
			try
			{
				roman.setText(rCalc.convert_To_Roman(Integer.parseInt(num.getText())));
			}
			catch(Exception ex)
			{
				
			}
			
		}
		
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}