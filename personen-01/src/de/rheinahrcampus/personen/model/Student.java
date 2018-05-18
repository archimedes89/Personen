package de.rheinahrcampus.personen.model;

import de.rheinahrcampus.type.Geschlecht;
import de.rheinahrcampus.type.Studienfach;

public class Student extends Person
	{
	
	private Studienfach studienfach;
	private int matrikelnummer;
	private int beginnJahr;
	
	
	public Student(String nachname, String vorname, Geschlecht geschlecht, String geburtsdatum) 
		{
		this(nachname, vorname, geschlecht, geburtsdatum, null, 0);
		}
	
	public Student(String nachname, String vorname, Geschlecht geschlecht, String geburtsdatum
			, Studienfach studienfach, int beginnJahr)
		{
		super(nachname, vorname, geschlecht, geburtsdatum);
		this.studienfach = studienfach;
		setBeginnJahr(beginnJahr);
		}
	
	@Override
	public String toString()
		{
		return String.format("%s, (Studienfach = %s, Matrikelnummer = %s, Beginnjahr = %s"
				, super.toString(), studienfach, matrikelnummer, beginnJahr);
		}
	
	@Override
	public String getAsString()
		{
		return String.format("%s, studiert mit der Matrikelnummer %s %s seit %s"
				, super.getAsString(), matrikelnummer, studienfach, beginnJahr);
		}

	public Studienfach getStudienfach()
		{
		return studienfach;
		}
	
	public void setStudienfach(Studienfach studienfach)
		{
		this.studienfach = studienfach;
		}
	
	public int getBeginnJahr()
		{
		return beginnJahr;
		}
	
	public void setBeginnJahr(int beginnJahr)
		{
		this.beginnJahr = beginnJahr;
		}
	
	public int getMatrikelnummer()
		{
		return matrikelnummer;
		}
	
	public final void setMatrikelNummer(int matrikelnummer)
		{
		this.matrikelnummer = matrikelnummer;
		}
	
	}

