package com.Anton;

public class People {

	// ��� ������� ��� ������� 
	
	private String name;
	private String name2;
	private boolean pol;
	private int years;
	
	
	public People(String name, String name2, boolean pol, int years) {
		super();
		this.name = name;
		this.name2 = name2;
		this.pol = pol;
		this.years = years;
	
	
	 
	}
	public String getName() {   // get ����������� srt ����������� 
		return name;
	}
	public String getName2() {
		return name2;
	}
	public boolean isPol() {
		return pol;
	}
	public int getYears() {
		return years;
	}
	

	
}
