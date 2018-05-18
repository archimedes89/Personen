package de.rheinahrcampus.type;

public enum Geschlecht 
	{
	WEIBLICH(1, "w", "weiblich"), MAENNLICH(2, "m", "männlich");
	
	private int value;
	private String shortName;
	private String longName;
	
	private Geschlecht(int value, String shortName, String longName)
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
