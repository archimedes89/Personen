package de.rheinahrcampus.type;

public enum Fachbereich 
	{
	MATHEUNDTECHNIK(1, "MT", "Mathematik und Technik"), WIRTSCHAFTUNDSOZIAL(2, "WS", "Wirtschaft- und Sozialwissenschaften");
	
    private int value;
    private String shortName;
    private String longName;
    
    private Fachbereich(int value, String shortName, String longName)
    	{
    	this.value = value;
    	this.shortName = shortName;
    	this.longName = longName;
    	}
   
    public String toString()
    	{
    	return longName;
    	}
    
    public int getvalue()
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
