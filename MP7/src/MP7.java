import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class MP7 extends Frame
{

	public static void main(String[] args)
	{

		//Labels
		JLabel romanLabel1 = new JLabel("Roman");
		JLabel intLabel1 = new JLabel("Integer");
		JLabel romanResultLabel = new JLabel("Roman Result");
		JLabel intResultLabel = new JLabel("Integer Result");
		
		
		//Text boxes
		JTextField roman1 = new JTextField(10);
		roman1.setEditable(false);
		JTextField int1 = new JTextField(10);
		JTextField roman2 = new JTextField(10);
		roman2.setEditable(false);
		JTextField int2 = new JTextField(10);
		JTextField intResult = new JTextField(10);
		JTextField romanResult = new JTextField(10);
		romanResult.setEditable(false);
		
		//Setup buttons in a JButton array
		JButton[] Opers = new JButton[6];
		Opers[0] = new JButton("+");
		Opers[0].setName("ADD");
		
		Opers[1] = new JButton("-");
		Opers[1].setName("SUB");
		
		Opers[2] = new JButton("*");
		Opers[2].setName("MULT");
		
		Opers[3] = new JButton("/");
		Opers[3].setName("DIV");
		
		Opers[4] = new JButton("%");
		Opers[4].setName("REMAIN");
		
		Opers[5] = new JButton("=");
		Opers[5].setName("EQU");
		
		//Setup CE button, this needs to be outside the array above
		JButton ce = new JButton("CE");
		ce.setName("ce");
		
		//Setup Roman numeral buttons
		JButton I = new JButton("I");
		I.setName("I");
		JButton V = new JButton("V");
		V.setName("V");
		JButton X = new JButton("X");
		X.setName("X");
		JButton L = new JButton("L");
		L.setName("L");
		JButton C = new JButton("C");
		C.setName("C");
		JButton D = new JButton("D");
		D.setName("D");
		JButton M = new JButton("M");
		M.setName("M");
		
		//Only allow numbers in the number fields
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
		decimalFormat.setGroupingUsed(false);
		int1 = new JFormattedTextField(decimalFormat);
		int1.setColumns(15);
		
		int2 = new JFormattedTextField(decimalFormat);
		int2.setColumns(15);
		
		intResult = new JFormattedTextField(decimalFormat);
		intResult.setColumns(15);
		
		//Add tool tips
		roman1.setToolTipText("Click to set as active, right click to clear.");
		roman2.setToolTipText("Click to set as active, right click to clear.");

		//Add action listeners for text boxes
		roman1.addMouseListener(new MouseClick(roman1));
		roman2.addMouseListener(new MouseClick(roman2));
		
		roman2.getDocument().addDocumentListener(new RomanTextAction(roman2, int2, false));
		roman1.getDocument().addDocumentListener(new RomanTextAction(roman1, int1, false));
		intResult.getDocument().addDocumentListener(new RomanTextAction(romanResult, intResult, true));
		int1.getDocument().addDocumentListener(new RomanTextAction(roman1, int1, true));
		int2.getDocument().addDocumentListener(new RomanTextAction(roman2, int2, true));
		
		//Action listeners for the Roman buttons
		I.addActionListener(new ButtonAction(I, roman1, roman2));
		V.addActionListener(new ButtonAction(V, roman1, roman2));
		X.addActionListener(new ButtonAction(X, roman1, roman2));
		L.addActionListener(new ButtonAction(L, roman1, roman2));
		C.addActionListener(new ButtonAction(C, roman1, roman2));
		D.addActionListener(new ButtonAction(D, roman1, roman2));
		M.addActionListener(new ButtonAction(M, roman1, roman2));
		
		//Action listeners for operators and special buttons
		ce.addActionListener(new SpecialButton(ce, roman1, roman2, int1, int2, romanResult));
		Opers[0].addActionListener(new SpecialButton(Opers));
		Opers[1].addActionListener(new SpecialButton(Opers));
		Opers[2].addActionListener(new SpecialButton(Opers));
		Opers[3].addActionListener(new SpecialButton(Opers));
		Opers[4].addActionListener(new SpecialButton(Opers));
		Opers[5].addActionListener(new SpecialButton(roman1, roman2, intResult, Opers));
		
		
		//Layout the window
		GridLayout main = new GridLayout(4, 2);
		
		//Top panel for text boxes and labels
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(3,3)); 
		topPanel.add(romanLabel1);
		topPanel.add(intLabel1);
		topPanel.add(roman1);
		topPanel.add(int1);
		topPanel.add(roman2);
		topPanel.add(int2);
		
		//Second panel for the results and labels
		JPanel secondTop = new JPanel();
		secondTop.setLayout(new GridLayout(2,2));
		secondTop.add(romanResultLabel);
		secondTop.add(intResultLabel);
		secondTop.add(romanResult);
		secondTop.add(intResult);
		
	
	    //Set the mid panel for Roman numerals and CE
		JPanel midPanel = new JPanel();
		midPanel.setLayout(new GridLayout(2,2));
		midPanel.add(I);
		midPanel.add(V);
		midPanel.add(X);
		midPanel.add(L);
		midPanel.add(C);
		midPanel.add(D);
		midPanel.add(M);
		midPanel.add(ce);
		
	    //Add all operators in the Opers array to the bottom panel
	    JPanel bottompanel = new JPanel();
	    bottompanel.setLayout(new GridLayout(2,2));
	    for(JButton btn : Opers)
	    {
	    	bottompanel.add(btn);
	    }

		
		//JFrame
		JFrame frame = new JFrame("Calculator");
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 400);
		frame.setName("Main");
		frame.setLayout(main);
		frame.add(topPanel);
		frame.add(secondTop);
		frame.add(midPanel);
		frame.add(bottompanel);
		
		frame.setVisible(true);
	}
	
}