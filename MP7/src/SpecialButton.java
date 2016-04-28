import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

class SpecialButton implements ActionListener
{

	private JButton btn;
	ArrayList<JTextField> textBoxes = new ArrayList<JTextField>();
	private JButton[] Opers;
	private RomanCalculator rCalc = new RomanCalculator();
	private JTextField rom1, rom2, result;
	
	SpecialButton(JButton b, JTextField... txArray)
	{
		btn = b;
		for(JTextField text : txArray)
			{
				textBoxes.add(text);
			}
		
	}
	
	SpecialButton(JButton[] ops)
	{
		Opers = ops;
	}
	
	SpecialButton(JTextField r1, JTextField r2, JTextField resu, JButton[] ops)
	{
		rom1 = r1;
		rom2 = r2;
		result = resu;
		Opers = ops;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Run the method depending on the button name
		switch(e.getActionCommand())
		{
		case "CE":
			CE();
			break;
			
		case "+":
			ADD();
			break;
			
		case "-":
			SUB();
			break;
			
		case "*":
			MULT();
			break;
			
		case "/":
			DIV();
			break;
			
		case "%":
			REMAIN();
			break;
			
		case "=":
			EQU();
			break;
		}
	}
	
	private void CE()
	{
		for(JTextField text : textBoxes)
		{
			text.setText(null);
			text.setBackground(null);
		}
	}
	
	private void ADD()
	{
		for(JButton btn : Opers)
		{
			
			if(btn.getName() == "ADD" && btn.getBackground() != Color.RED)
			{
				
				btn.setBackground(Color.RED);
			}
			else
			{
				btn.setBackground(null);
			}
		}
	}
	
	private void SUB()
	{
		for(JButton btn : Opers)
		{
			
			if(btn.getName() == "SUB" && btn.getBackground() != Color.RED)
			{
				
				btn.setBackground(Color.RED);
			}
			else
			{
				btn.setBackground(null);
			}
		}
	}
	
	private void MULT()
	{
		for(JButton btn : Opers)
		{
			
			if(btn.getName() == "MULT" && btn.getBackground() != Color.RED)
			{
				
				btn.setBackground(Color.RED);
			}
			else
			{
				btn.setBackground(null);
			}
		}
	}
	
	private void DIV()
	{
		for(JButton btn : Opers)
		{
			
			if(btn.getName() == "DIV" && btn.getBackground() != Color.RED)
			{
				
				btn.setBackground(Color.RED);
			}
			else
			{
				btn.setBackground(null);
			}
		}
	}
	
	private void REMAIN()
	{
		for(JButton btn : Opers)
		{
			
			if(btn.getName() == "REMAIN" && btn.getBackground() != Color.RED)
			{
				
				btn.setBackground(Color.RED);
			}
			else
			{
				btn.setBackground(null);
			}
		}
	}
	
	private void EQU()
	{
		for(JButton btn : Opers)
		{
			if(btn.getBackground() == Color.RED)
			{
				switch(btn.getName())
				{
				case "ADD":
					result.setText(Integer.toString(rCalc.convert_From_Roman(rom1.getText()) + rCalc.convert_From_Roman(rom2.getText()) ));
					break;
					
				case "SUB":
					result.setText(Integer.toString(rCalc.convert_From_Roman(rom1.getText()) - rCalc.convert_From_Roman(rom2.getText()) ));
					break;
					
				case "MULT":
					result.setText(Integer.toString(rCalc.convert_From_Roman(rom1.getText()) * rCalc.convert_From_Roman(rom2.getText()) ));
					break;
					
				case "DIV":
					result.setText(Double.toString((double)rCalc.convert_From_Roman(rom1.getText()) / (double)rCalc.convert_From_Roman(rom2.getText()) ));
					break;
					
				case "REMAIN":
					result.setText(Integer.toString(rCalc.convert_From_Roman(rom1.getText()) % rCalc.convert_From_Roman(rom2.getText()) ));
					break;
				}
			}
		}
		
	}
	
	private void clearOpers()
	{
		for(JButton btn : Opers)
		{
			btn.setBackground(null);
		}
	}
}