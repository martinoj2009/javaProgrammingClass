class boardPosition
{
	private char position;
	private boolean used;
	private char userSign;

	boardPosition(char letter)
	{
		setPosition(letter);
		setUsed(false);
	}
	
	boardPosition()
	{
		setPosition('a');
		setUsed(false);
	}
	public char getPosition() {
		return position;
	}

	public void setPosition(char position) {
		this.position = position;
	}

	public char isUsed() {
		if(used == true)
		{
			return userSign;
		}
		else
		{
			return ' ';
		}
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public char getUserSign() {
		return userSign;
	}

	public void setUserSign(char userSign) {
		this.userSign = userSign;
	}
	
	
	
	
	
	
	
}