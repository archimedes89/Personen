package de.rheinahrcampus.personen.test;

import de.rheinahrcampus.personen.model.Dozent;
import de.rheinahrcampus.personen.model.Person;
import de.rheinahrcampus.personen.model.Student;
import de.rheinahrcampus.type.Fachbereich;
import de.rheinahrcampus.type.Geschlecht;
import de.rheinahrcampus.type.Studienfach;


public class PersonTest 
	{
	private static void testPersonObjekte()
		{
		Person person1 = new Person("Curie", "Marie", Geschlecht.WEIBLICH, "07.11.1867");
		Person person2 = new Person("Einstein", "Albrecht", Geschlecht.MAENNLICH, "14.03.1879");
		Person person3 = person2.clone();
		Person dozent1 = new Dozent("Dahm", "David", Geschlecht.MAENNLICH, "15.09.1971", Fachbereich.MATHEUNDTECHNIK, 4800);
		Person student1 = new Student("Fischer", "Robert", Geschlecht.MAENNLICH, "09.03.1943", Studienfach.BIOMATHEMATIK, 2015);
		
		
		System.out.print("\n\n\n\n\n");
		System.out.println(person2.getAsString());
		System.out.println(person1.getAsString());
		System.out.println(person2.toString());
		System.out.println(person3.getAsString());
		System.out.println(person2.getAnrede());
		System.out.println("\n" + dozent1.getAsString());
		System.out.println("\n" + student1.getAsString());
		System.out.println("\n" + student1.toString());
		System.out.println(((Student) student1).getMatrikelnummer());
		Person person4 = person1.clone();
		System.out.println(person4.toString());
		}
	
	private static Person[] generatePersonen()
	{
	Person[] personen = new Person[12];
	Student student2 = new Student("Siebert", "Sabine", Geschlecht.WEIBLICH,"07.01.1994"
			, Studienfach.WIRTSCHAFTSMATHEMATIK, 2012);
	
	Dozent dozent2 = new Dozent("Jauch", "Günther", Geschlecht.MAENNLICH, "05.04.1968",
			Fachbereich.MATHEUNDTECHNIK, 4500);
	
	personen[0] = student2;
	personen[1] = dozent2;
	
	return personen;
	}
	
	private static void printPersonen(Person[] personliste)
		{
		for(Person person: personliste)
			{
			if(person == null) break;
			System.out.println(person.getAsString());
			}
		}
	
	private static void printPersonObjekte(Person[] personliste)
		{
		for(Person person: personliste)
			{
			if(person == null) break;
			System.out.println(person.toString());
			}
		}
	
	private static void printObjekte (Object[] objektliste)
		{
		for(Object objekt: objektliste)
			{
			if(objekt == null) break;
			System.out.println(objekt.toString());
			}
		}
	
	public static void main(String[] args) 
		{
		testPersonObjekte();
		Person[] personen = generatePersonen();
		printPersonen(personen);
		printPersonObjekte(personen);
		printObjekte(personen);
		}

	}
