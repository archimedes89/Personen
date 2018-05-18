
package de.rheinahrcampus.personen.model;

import de.rheinahrcampus.type.Anrede;
import de.rheinahrcampus.type.Geschlecht;

public class Person implements Comparable <Person>
	{
	private static final int ID_MISSING_VALUE = -1;
	private int id = ID_MISSING_VALUE;
	
	private Anrede anrede;
	private Geschlecht geschlecht;
	private String vorname;
	private String nachname;
	private String geburtsdatum;
	
	
	public Person(String nachname, String vorname, Geschlecht geschlecht, String geburtsdatum)
		{
		setNachname(nachname);
		setVorname(vorname);
		this.geschlecht = geschlecht;
		setGeburtsdatum(geburtsdatum);
		}
	
	
	public static Person copyInstance(Person person)
		{  
		return person.clone(); 
		}
	
	public Person clone()
		{
		Person person = new Person(nachname, vorname, geschlecht, geburtsdatum);
		person.setId(this.id);
		return person;
		}
	
	public boolean equals(Object object) 
		{   
		if (! (object instanceof Person)) return false; 
		Person otherPerson = (Person)object;
		if(getId() != ID_MISSING_VALUE && otherPerson.getId() != ID_MISSING_VALUE)
			{
			return getId() == otherPerson.getId();
			}
		else
			{
			return getNachname().equals(otherPerson.getNachname()) && getVorname().equals(otherPerson.getVorname()) 
			&& getGeburtsdatum().equals(otherPerson.getGeburtsdatum());
			}
		}
	
	public String toString()
		{
		return String.format("%s: (id = %d ,Nachname = %s, Vorname = %s, Geschlecht = %s, Geburtsdatum = %s, Anrede = %s)"
				,getClass().getSimpleName(), id, nachname, vorname, geschlecht, geburtsdatum, getAnrede());
		}
	
	public String getAsString()
		{
		return String.format("%s, %s: %s, geb. am %s", 
				getNachname(), getVorname(), getGeschlecht().getShortName(), getGeburtsdatum());
		}
	
	private String trim(String string)
		{
		if(string == null || string.trim().isEmpty()) return null;
		return string.trim();
		}
	
	@Override
	public int compareTo(Person person)
		{
		int vglNachname = getNachname().compareTo(person.getNachname());
		if(vglNachname != 0) return vglNachname;
		int vglVorname = getVorname().compareTo(person.getVorname());
		if(vglVorname != 0) return vglVorname;
		return getGeburtsdatum().compareTo(person.getGeburtsdatum());
		}
	
	public int getId()
		{
		return id;
		}
	
	public void setId(int id)
		{
		if(this.id == ID_MISSING_VALUE)
			{
			this.id = id;
			}
		}
	
	public String getNachname()
		{
		return nachname;
		}
	
	public void setNachname(String nachname)
		{
		this.nachname = trim(nachname);
		}
	
	public String getVorname() 
		{
		return vorname;	
		}
	
	public void setVorname(String vorname)
		{
		this.vorname = vorname;
		}
	
	public Geschlecht getGeschlecht()
		{
		return geschlecht;
		}
	
	public String getGeburtsdatum()
		{
		return geburtsdatum;
		}
	
	public void setGeburtsdatum(String geburtsdatum)
		{
		this.geburtsdatum = geburtsdatum;
		}
	
	public Anrede getAnrede()
		{
		if(anrede != null) return anrede;
		switch(getGeschlecht())
			{
		case WEIBLICH: return Anrede.FRAU;
		case MAENNLICH: return Anrede.HERR;
		default: 		return null;
			}
		}
	
	public void setAnrede(Anrede anrede)
		{
		this.anrede = anrede;
		}
	}
