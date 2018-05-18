package de.rheinahrcampus.personen.db;

public class IdDummyDao
	{
	private String[] types = new String[] {"Person", "Adresse"};
	private int[] nextFreeIds = new int[] {1,1}; 
	
	public int generateId(String type)
		{
		for(int i = 0; i < types.length; i++)
			{
			if(types[i].equals(type))
				{
				int id = 1000 + nextFreeIds[i];
				nextFreeIds[i]++;
				return id;
				}
			}
		return -1;
		}
	}
