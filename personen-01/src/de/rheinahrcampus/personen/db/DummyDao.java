package de.rheinahrcampus.personen.db;

public abstract class DummyDao
	{
	protected static final IdDummyDao idDao = new IdDummyDao();
	
	private static final int MAX_COUNT = 12;
	
	private Object[] container = new Object[MAX_COUNT];
	private int objectCount = 1;
	
	protected abstract boolean setId(Object object);
	
	
	protected boolean insert(Object object)
		{
		if(objectCount >= MAX_COUNT) return false;
		if(exists(object)) return false;
		if(!(setId(object))) return false;
		container[objectCount++] = object;
		return true;
		}
	
	public boolean update(Object object)
		{
		int posObject = getIndex(object);
		if(posObject < 0) return false;
		container[posObject] = object;
		return true;
		}
	
	public boolean delete(Object object)
		{
		int posObject = getIndex(object);
		if(posObject < 0) return false;
		for(int i = posObject; i <=  objectCount - 1; i++)
			{
			container[i] = container[i+1];
			}
		container[objectCount - 1] = null;
		--objectCount;
		return true;
		}
	
	public void deleteAll(Object object)
		{
		container = new Object[container.length];
		objectCount = 1;
		}
	
	public void printAll()
		{
		System.out.format("%n%nAlle Objekte: Anzahl: %d", objectCount);
		int number = 0;
		for(Object object : container)
			{
			if(object == null) break;
			++number;
			System.out.format("%n%s. %s", number, object.toString());
			}
		}
	
	public boolean exists(Object object)
		{
		return getIndex(object) >= 0;
		}
	
	public int getObjectCount()
		{
		return objectCount;
		}
	
	public int getIndex(Object object)
	{
	for(int i = 0; i < container.length; i++)
		{
		if(container[i] == null) break;
		if(container[i].equals(object)) return i;
		}
	return -1;
	}
	
	public abstract Object[] getContainer();
	}
