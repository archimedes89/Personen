package de.rheinahrcampus.personen.model;

public class Adresse
	{
	
	private int plz;
    private String ort;
    private String strasse;
    private String hausNummer;
	    
    public Adresse(int plz, String ort, String strasse, String hausNummer) 
    	{
	   	setPlz(plz);
	   	setOrt(ort);
	   	setStrasse(strasse);
	   	setHausNummer(hausNummer);
	    }
	    
	    
    public String getFormatierteAdresse() 
    	{
    	return String.format("%s    %s				%s				%s"
    			, plz, ort, strasse, hausNummer);
	    }
	    
	  				
    public String getAsFormattedString() 
    	{
	    return String.format("%s: (plz = %s, Ort = %s, Strasse = %s, Hausnummer = %s"
	    		, plz, ort, strasse, hausNummer);
    	}
	    
	  
	public String toString()
		{
	   	return String.format("%s:(plz=%s,ort=%s,strasse=%s,hausNummer=%s)",
	    			              getClass().getSimpleName(),
	    			              plz, ort, strasse, hausNummer);
	    }
	    
	public boolean equals(Object object) 
		{   
		if (! (object instanceof Adresse)) return false; 
		Adresse otherAdresse = (Adresse)object;
		
		return getPlz() == otherAdresse.getPlz() && getOrt().equals(otherAdresse.getOrt())
				&& getStrasse().equals(otherAdresse.getStrasse()) && getHausNummer().equals(otherAdresse.getHausNummer());
		}

	public Adresse clone()
		{
		Adresse otherAdresse = new Adresse(getPlz(), getOrt(), getStrasse(), getHausNummer());
		return otherAdresse;
		}

	  
	private String trim(String string)
		{
	    if (string == null || string.trim().isEmpty()) return null;
        return string.trim(); 
	    }
	    
	    public String getHausNummer() 
	    	{
	    	return hausNummer;
	    	}
	    
	    private void setHausNummer(String hausNummer) 
	    	{
	    	this.hausNummer = trim(hausNummer);
	    	}
	    
	    public String getOrt() 
	    	{
	    	return ort;
	    	}
	    
	    private void setOrt(String ort)
	    	{
	    	this.ort = trim(ort);
	    	}
	    
	    public int getPlz() 
	    	{
	    	return plz;
	    	}
	    
	    private void setPlz(int plz) 
	    	{
	    	this.plz = plz;
	    	}
	    
	    public String getStrasse() 
	    	{
	    	return strasse;
	    	}
	    
	    private void setStrasse(String strasse) 
	    	{
	    	this.strasse = trim(strasse);
	    	}

	}

	
