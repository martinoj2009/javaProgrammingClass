
public class Roman {
	private String rom;
	private int dec;
	
	public Roman()
	{
		rom = "";
		dec = 0;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public int getDec() {
		return dec;
	}

	public void setDec(int dec) {
		this.dec = dec;
	}
	
	public void convertDecimalToRoman()
	{
		int dec = this.dec;
		this.rom = "";
		
		int Ms = dec / 1000;
		for (int i = 1; i <= Ms; i++)
			rom += "M";
		dec = dec % 1000;

		int Ds = dec / 500;
		for (int i = 1; i <= Ds; i++)
			rom += "D";
		dec = dec % 500;

		int Cs = dec / 100;
		for (int i = 1; i <= Cs; i++)
			rom += "C";
		dec = dec % 100;

		int Ls = dec / 50;
		for (int i = 1; i <= Ls; i++)
			rom += "L";
		dec = dec % 50;

		int Xs = dec / 10;
		for (int i = 1; i <= Xs; i++)
			rom += "X";
		dec = dec % 10;

		int Vs = dec / 5;
		for (int i = 1; i <= Vs; i++)
			rom += "V";
		dec = dec % 5;

		int Is = dec / 1;
		for (int i = 1; i <= Is; i++)
			rom += "I";
		dec = dec % 1;
	}
	
	public void convertRomanToDecimal()
	{
		dec = 0;
		
		for (int i = 0; i < rom.length(); i++)
		{
			switch(rom.charAt(i))
			{
			case 'I': dec += 1; break;
			case 'V': dec += 5; break;
			case 'X': dec += 10; break;
			case 'L': dec += 50; break;
			case 'C': dec += 100; break;
			case 'D': dec += 500; break;
			case 'M': dec += 1000; break;
			}
		}		
	}
}
