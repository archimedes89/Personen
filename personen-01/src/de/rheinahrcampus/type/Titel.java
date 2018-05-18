package de.rheinahrcampus.type;

public enum Titel 
	{
	DOKTOR(1, "Dr.", "Doktor"), PROFESSOR(2, "Prof.", "Professor"), PROFDOKTOR(3, "Prof.Dr.", "Professor Doktor");
	
	private int value;
	private String shortName;
	private String longName;
	
	private Titel(int value, String shortName, String longName)
		{
		this.value = value;
		this.shortName = shortName;
		this.longName = longName;
		}
	
	public String toString()
		{
		return longName;
		}
	
	public int getValue()
		{
		return value;
		}
	
	public String getShortName()
		{
		return shortName;
		}
	
	public String getLongName()
		{
		return longName;
		}
	}
