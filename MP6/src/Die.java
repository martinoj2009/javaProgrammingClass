class Die
{
	
	private int value;
	
	Die()
	{
		setValue(1 + (int)(Math.random() * 6));
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	

}