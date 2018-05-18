package de.rheinahrcampus.personen.test;

import de.rheinahrcampus.personen.model.Adresse;

public class PersonAdresseTest
	{
	
	public static void testAdresseObjekte()
		{
		Adresse a1 = new Adresse(56637, "Plaidt", "Michelbergstr.", "3");
		Adresse a2 = new Adresse(56751, "Polch", "Am Bahnhof", "12");
		Adresse a3 = new Adresse(56751, "Polch", "St.Sebastianusstr.", "8");
		
		Adresse a4 = a3.clone();
		
		
		System.out.println(a2.getFormatierteAdresse());
		System.out.println(a4.getFormatierteAdresse());
		System.out.println(a4.equals(a3));
		System.out.println(a1.equals(a2));
		}
	
	
	public static void main(String[] args) 
		{
		testAdresseObjekte();
		}

	}
