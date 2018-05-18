package de.rheinahrcampus.personen.model;

import de.rheinahrcampus.type.Fachbereich;
import de.rheinahrcampus.type.Geschlecht;

public class Dozent extends Person
	{
	private Fachbereich fachbereich;
	private double gehalt;
	
	public Dozent(String nachname, String vorname, Geschlecht geschlecht, String geburtsdatum)
		{
		super(nachname, vorname, geschlecht, geburtsdatum);
		}
	
	public Dozent(String nachname, String vorname, Geschlecht geschlecht, String geburtsdatum,
			Fachbereich fachbereich, double gehalt)
		{
		super(nachname, vorname, geschlecht, geburtsdatum);
		this.fachbereich = fachbereich;
		this.gehalt = gehalt;
		}
	
	@Override
	public String toString()
		{
		return String.format("%s, (Fachbereich = %s, Gehalt = %.2f"
				, super.toString(), getFachbereich().getLongName(), getGehalt());
		}
	
	@Override
	public String getAsString()
		{
		return String.format("%s, ist Mitarbeiter des Fachbereichs %s mit dem Gehalt von %.2f €"  
				,super.getAsString(), getFachbereich().getLongName(), getGehalt());
		}
	
	public Fachbereich getFachbereich()
		{
		return fachbereich;
		}
	
	public void setFachbereich(Fachbereich fachbereich)
		{
		this.fachbereich = fachbereich;
		}
	
	public double getGehalt()
		{
		return gehalt;
		}
	
	public void setGehalt(double gehalt)
		{
		this.gehalt = gehalt;
		}
	}
