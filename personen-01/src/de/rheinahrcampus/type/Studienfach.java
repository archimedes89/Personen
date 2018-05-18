package de.rheinahrcampus.type;

public enum Studienfach
	{
	BIOMATHEMATIK(1, "BM", "Biomathematik"), LASERTECHNIK(2, "LT", "Lasertechnik"), MEDIZINTECHNIK(3, "MT", "Medizintechnik")
	, SOFTWAREENG(4, "SE", "Software Engineering"), SPORTMEDTECH(4, "ST", "Sportmedizinische Technik")
	, TECHNOMATHEMATIK(5, "TM", "Technomathematik"), WIRTSCHAFTSMATHEMATIK(6, "WM", "Wirtschaftsmathematik");
	
	private int value;
	private String shortName;
	private String longName;
	
	private Studienfach(int value, String shortName, String longName)
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
