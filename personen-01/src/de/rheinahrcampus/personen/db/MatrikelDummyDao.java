package de.rheinahrcampus.personen.db;

import java.time.LocalDate;

public class MatrikelDummyDao 
	{
	private int count = 1;
	
	public int generateMatrikelNummer()
		{
		LocalDate heute = LocalDate.now();
		return heute.getYear() * 1000 + count++;
		}
	}
