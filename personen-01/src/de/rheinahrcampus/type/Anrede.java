package de.rheinahrcampus.type;

public enum Anrede 
	{
	FRAU(1, "Frau"), HERR(2,"Herr"), FRAEULEIN(3, "Fräulein");
	
	private int value;
	private String name;
	
	private Anrede(int value, String name)
		{
		this.value = value;
		this.name = name; 
		}
	
	public String toString()
		{
		return name;
		}
	
	public int getValue()
		{
		return value;
		}
	
	public String getName()
		{
		return name;
		}
	}

