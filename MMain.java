package com.Anton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MMain {

	
	public static ArrayList<People> peoples = new ArrayList<People>(); // ������ - � ��� �������� , ������ � ������ �����������
	
	public static void main(String[] args) throws IOException {
	
		
		while(true) {
		
			int menu = -1;
			System.out.println("1.�������� ������������");  
			System.out.println("2.������� ������������"); 
			System.out.println("3.������� ���� �������������"); 
			System.out.println("4.���������� ���������� � ������������");
			System.out.println("5.��������� ������ �� ��");
			System.out.println("0.�����");
			
			Scanner input = new Scanner(System.in); 
			menu = input.nextInt();
			
			if(menu == 0) break ; // 0 - exit
			 
			if(menu == 1) addPeople() ; // 1 - �������� �������������
			
			if(menu == 3) showAll() ;

			if(menu == 2) delete();
			
			if(menu == 4) showOnly();
			
			if(menu == 5) unload();
			
			// ��������� 4, �� ������ ������ ��� ��� ����� (������� �������� �� �����) � ����� ����� �� ������� ���������� ���-�� ���� 
		}
		
		
	}

	
	
	public static void addPeople () {  // this �� �� � ������

		String name;
		String name2;
		boolean pol;
		int years;
		
		Scanner inpt = new Scanner(System.in);
		name = inpt.nextLine();
		name2 = inpt.nextLine();
		pol = inpt.nextLine().equals("�") ? true : false ; // �������� �� ����. �������� �� ���� ����� � , ���� �, �� ������ � ��..
		years = Integer.parseInt(inpt.nextLine()); // ������ ����������� � ���
		
		peoples.add(new People(name, name2, pol, years)); //��������� � ������ ��������� ����� ������ ����, �.� �� ��������� �����, �� ������� ����� ������ , ��������� ���������
		
	
		
	}
	
	
	public static void delete () {
		
		int delete;
		
		Scanner del = new Scanner(System.in);
		delete = Integer.parseInt(del.nextLine());
		
		peoples.remove(delete) ;
	}
		
	
	//////// UNLOAD !!
	
		
		public static void unload () {
			
			File file = new File ("people.txt"); 
			
			
			if(!file.exists())
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}  //FileWriter 
			
			
			int pos = 1; // �� ������ ���� ������ ��� �� �����������
				
			
			for(People p : peoples) {
				
					
				//	System.out.println(peoples.size());
					pw.println("���:" + p.getName());
					pw.println("�������:" + p.getName2());
					pw.println("���:" + p.isPol());
					pw.println("������ ���:" + p.getYears() + ".\n--------");
					pw.println("����� �����:" + peoples.size());  
					
					pw.println(pos +"." + p.getName() + " "+ p.getName2() + " | " + p.getYears()+ " ���" + " | " + (p.isPol() ? "�������" : "�������" ));
					pos++;
					
			}
					pw.println(); 
					pw.close();
			}
		
		
		
		
		//////
		
		
		public static void showOnly () {
		
		int onepeople;
		
		
		Scanner only = new Scanner(System.in);
		onepeople = Integer.parseInt(only.nextLine());
		
	//	System.out.println(peoples.get(onepeople).getName());
		
		People p = peoples.get(onepeople);
		
		System.out.println("���:" + p.getName());
		System.out.println("�������:" + p.getName2());
		System.out.println("���:" + p.isPol());
		System.out.println("������ ���:" + p.getYears() + ".\n--------");
		
		
		}
		
	
	
	
	@SuppressWarnings("unused")
	public static void showAll () {
		
	//	int x = 0;
	//	for(int x = 0;  x < 1; x++) {
		for(People p : peoples) {
		//	System.out.println(peoples.size());
			System.out.println("���:" + p.getName());
			System.out.println("�������:" + p.getName2());
			System.out.println("���:" + (p.isPol() ? "�������" : "�������" ));
			System.out.println("������ ���:" + p.getYears() + ".\n--------");
		
			System.out.println("����� �����:" + peoples.size());
		}
			
			
		
	
	
	}
	
	
	
}









