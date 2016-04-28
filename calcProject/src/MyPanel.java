import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyPanel extends JPanel implements ActionListener {
	
	private Roman r1 = new Roman();
	private Roman r2 = new Roman();
	private Roman r3 = new Roman();
	
	private JPanel operPan = null;
	private JPanel disPan = null;
	
	private JButton btnMul = null;
	private JButton btnDiv = null;
	private JButton btnAdd = null;
	private JButton btnSub = null;
	private JButton btnEq = null;
	private JButton btnClr = null;
	
	private JTextField tfRom1 = null;
	private JTextField tfRom2 = null;
	private JTextField tfRom3 = null;

	private JTextField tfDec1 = null;
	private JTextField tfDec2 = null;
	private JTextField tfDec3 = null;

	public MyPanel()
	{
		super();
		this.operPan = new JPanel();
		this.operPan.setLayout(new GridLayout(4, 1));
		
		this.disPan = new JPanel();
		this.disPan.setLayout(new GridLayout(4, 2));
		
		this.btnAdd = new JButton("+");
		this.btnAdd.addActionListener(this);
		
		this.btnClr = new JButton("CLR");
		this.btnClr.addActionListener(this);
		
		this.btnDiv = new JButton("/");
		this.btnDiv.addActionListener(this);
		
		this.btnEq = new JButton("=");
		this.btnEq.addActionListener(this);
		
		this.btnMul = new JButton("*");
		this.btnMul.addActionListener(this);
		
		this.btnSub = new JButton("-");
		this.btnSub.addActionListener(this);
		
		this.tfDec1 = new JTextField();
		this.tfDec1.setEnabled(false);
		
		this.tfDec2 = new JTextField();
		this.tfDec2.setEnabled(false);

		this.tfDec3 = new JTextField();
		this.tfDec3.setEnabled(false);
		
		this.tfRom1 = new JTextField();
		this.tfRom2 = new JTextField();
		
		this.tfRom3 = new JTextField();
		this.tfRom3.setEnabled(false);
		
		this.disPan.add(tfRom1);
		this.disPan.add(tfDec1);
		this.disPan.add(tfRom2);
		this.disPan.add(tfDec2);
		this.disPan.add(tfRom3);
		this.disPan.add(tfDec3);
		this.disPan.add(btnEq);
		this.disPan.add(btnClr);
		
		this.operPan.add(btnMul);
		this.operPan.add(btnDiv);
		this.operPan.add(btnAdd);
		this.operPan.add(btnSub);
		
		this.setLayout(new BorderLayout());
		this.add(operPan, BorderLayout.EAST);
		this.add(disPan, BorderLayout.CENTER);
		
		this.setPreferredSize(new Dimension(400, 400));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		r1.setRom(this.tfRom1.getText());
		r1.convertRomanToDecimal();
		this.tfDec1.setText(""+ r1.getDec());
		
		r2.setRom(this.tfRom2.getText());
		r2.convertRomanToDecimal();
		this.tfDec2.setText(""+ r2.getDec());
		
		switch(e.getActionCommand())
		{
		case "*": 
			r3.setDec(r1.getDec() * r2.getDec());
			r3.convertDecimalToRoman();
			break;
		case "/": 
			r3.setDec(r1.getDec() / r2.getDec());
			r3.convertDecimalToRoman();
			break;
		case "+": 
			r3.setDec(r1.getDec() + r2.getDec());
			r3.convertDecimalToRoman();
			break;
		case "-": 
			r3.setDec(r1.getDec() - r2.getDec());
			r3.convertDecimalToRoman();
			break;
		case "=":
			this.tfDec3.setText("" + r3.getDec());
			this.tfRom3.setText(r3.getRom());
			break;
		case "CLR":
			this.tfDec1.setText("");
			this.tfDec2.setText("");
			this.tfDec3.setText("");
			this.tfRom1.setText("");
			this.tfRom2.setText("");
			this.tfRom3.setText("");
			break;
		}
	}
}
