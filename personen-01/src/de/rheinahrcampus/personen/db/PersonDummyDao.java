package de.rheinahrcampus.personen.db;

import java.util.Arrays;

import de.rheinahrcampus.personen.model.Person;
import de.rheinahrcampus.personen.model.Student;
import de.rheinahrcampus.type.Geschlecht;

public class PersonDummyDao extends DummyDao
	{
	
	private static PersonDummyDao uniqueInstance = new PersonDummyDao();
	
	private PersonDummyDao() {};
	
	public static PersonDummyDao getUniqueInstance()
		{
		return uniqueInstance;
		}
	
	private static final int MAX_COUNT = 12;
	
	private Person container[] = new Person[MAX_COUNT]; 
	private int objectCount = 1;
	
	private MatrikelDummyDao matrikelDao = new MatrikelDummyDao();
	protected static final IdDummyDao idDao = new IdDummyDao();
	
	public Person[] findAllPersonen()
		{
		Person[] ergebnis = new Person[getObjectCount()];
		int count = 0;
		for(Object object : getContainer())
			{
			if(object == null) break;
			ergebnis[count++] = (Person) object;
			}
		Arrays.sort(ergebnis);
		return ergebnis;
		}
	
	public Student[] findAllStudenten()
		{
		Student[] suchErgebnis = new Student[getObjectCount()];
		int count = 0;
		for(Object object : getContainer())
			{
			if(object == null) break;
			if(object instanceof Student)
				{
				suchErgebnis[count++] = (Student) object;
				}
			}
		Arrays.sort(suchErgebnis, 0, count);
		Student[] ergebnis = new Student[count];
		System.arraycopy(suchErgebnis, 0, ergebnis, 0, ergebnis.length);
		Arrays.sort(ergebnis);
		return ergebnis;
		}
	
	public Person[] findPersonByNachname(String nachname)
		{
		Person[] suchErgebnis = new Person[container.length];
		int count = 0;
		for(Person person : container)
			{
			if(person == null) break;
			if(person.getNachname().equals(nachname))
				{
				suchErgebnis[count++] = person;
				}
			}
		 Person[] ergebnis = new Person[count];
		 System.arraycopy(suchErgebnis, 0, ergebnis, 0, ergebnis.length);
		 Arrays.sort(ergebnis); 
		 return ergebnis; 
		}
	
	public Person[] findPersonByGeschlecht(Geschlecht geschlecht)
		{
		Person[] suchErgebnis = new Person[container.length];
		int count = 0;
		for(Person person : container)
			{
			if(person == null) break;
			if(person.getGeschlecht().equals(geschlecht))
				{
				suchErgebnis[count++] = person;
				}
			}
		 Person[] ergebnis = new Person[count];
		 System.arraycopy(suchErgebnis, 0, ergebnis, 0, ergebnis.length);
		 Arrays.sort(ergebnis); 
		 return ergebnis;
		}
	
	public Person getPerson(String nachname, String vorname, String geburtsdatum)
		{
		int posObjekt =  getIndex(new Person(nachname, vorname, null, geburtsdatum));
		return (posObjekt > 0)? container[posObjekt]: null;
		}
	
	public boolean insertPerson(Object object)
		{
		Person person = (Person) object;
		if(!super.insert(person)) return false;
		if(objectCount > MAX_COUNT) return false;
		if(exists(person)) return false;
		if(person instanceof Student)
			{
			int matrikelNummer = matrikelDao.generateMatrikelNummer();
			Student student = (Student) person;
			student.setMatrikelNummer(matrikelNummer);
			}
		return true;
		}
	
	protected boolean setId (Object object)
		{
		int id = idDao.generateId("Person");
		if(id < 0) return false;
		((Person) object).setId(id);
		return true;
		}
	
	public boolean updatePerson(Person person)
		{
		int posObjekt = getIndex(person);
		if(posObjekt < 0) return false;
		container[posObjekt] = person;
		return true;
		}
	
	public boolean delete(Person person)
		{
		int posObjekt = getIndex(person);      
		if (posObjekt < 0) return false;
		for(int i = posObjekt; i < objectCount - 1; i++)
			{
			container[i] = container[i+1];
			}
		container[objectCount - 1] = null;
		--objectCount;
		return true;
		}
				
	public boolean exists(Person person)
		{
		return getIndex(person) >= 0;
		}
	
	public int getObjectCount()
		{
		return objectCount;
		}
	
	public void deleteAll()
		{
		container = new Person[container.length];
		objectCount = 1;
		}
	
	public void printAll()
		{
		System.out.format("%n%nAlle Objekte: Anzahl: %d", objectCount);
		int number = 0;
		for(Person person : container)
			{
			if(person == null) break;
			++number;
			System.out.format("%n%s. %s", number, person.toString());
			}
		}
	
	public int getIndex(Person person)
		{
		for(int i = 0; i < container.length; i++)
			{
			if(container[i] == null) break;
			if(container[i].equals(person)) return i;
			}
		return -1;
		}
	
	public Person getPersonById(int id)
		{
		for(Object object : getContainer())
			{
			if(object == null) break;
			Person person = (Person) object;
			if(person.getId() == id)
				{
				return person;
				}
			}
		return null;
		}
	
	
	
	public Person[] getContainer()
		{
		return container;
		}
	
	}
