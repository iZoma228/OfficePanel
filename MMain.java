package com.Anton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MMain {

	
	public static ArrayList<People> peoples = new ArrayList<People>(); // первый - с чем работает , второй с какими параметрами
	
	public static void main(String[] args) throws IOException {
	
		
		while(true) {
		
			int menu = -1;
			System.out.println("1.Добавить пользователя");  
			System.out.println("2.Удалить пользователя"); 
			System.out.println("3.Вывести всех пользователей"); 
			System.out.println("4.Посмотреть информацию о пользователе");
			System.out.println("5.Выгрузить список на пк");
			System.out.println("0.Выход");
			
			Scanner input = new Scanner(System.in); 
			menu = input.nextInt();
			
			if(menu == 0) break ; // 0 - exit
			 
			if(menu == 1) addPeople() ; // 1 - добавить польщзователя
			
			if(menu == 3) showAll() ;

			if(menu == 2) delete();
			
			if(menu == 4) showOnly();
			
			if(menu == 5) unload();
			
			// нажимаешь 4, он просит ввести еще раз цифру (сделать проверку на цифру) и после ввода из массива показывает хар-ку чела 
		}
		
		
	}

	
	
	public static void addPeople () {  // this но не в статик

		String name;
		String name2;
		boolean pol;
		int years;
		
		Scanner inpt = new Scanner(System.in);
		name = inpt.nextLine();
		name2 = inpt.nextLine();
		pol = inpt.nextLine().equals("М") ? true : false ; // проверка на ввод. проверка на ввод буквы М , если М, то истино и тд..
		years = Integer.parseInt(inpt.nextLine()); // СТРОКА ПАРСИРУЕТСЯ В ИНТ
		
		peoples.add(new People(name, name2, pol, years)); //ДОПОЛНИЛИ в массив добавляем новый обьект пипл, т.к мы добавляем новый, мы создаем новый обьект , указываем параметры
		
	
		
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
			
			
			int pos = 1; // за циклом чтоб каждый раз не обновлялась
				
			
			for(People p : peoples) {
				
					
				//	System.out.println(peoples.size());
					pw.println("Имя:" + p.getName());
					pw.println("Фамилия:" + p.getName2());
					pw.println("Пол:" + p.isPol());
					pw.println("Полных лет:" + p.getYears() + ".\n--------");
					pw.println("Всего людей:" + peoples.size());  
					
					pw.println(pos +"." + p.getName() + " "+ p.getName2() + " | " + p.getYears()+ " лет" + " | " + (p.isPol() ? "Мужчина" : "Женщина" ));
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
		
		System.out.println("Имя:" + p.getName());
		System.out.println("Фамилия:" + p.getName2());
		System.out.println("Пол:" + p.isPol());
		System.out.println("Полных лет:" + p.getYears() + ".\n--------");
		
		
		}
		
	
	
	
	@SuppressWarnings("unused")
	public static void showAll () {
		
	//	int x = 0;
	//	for(int x = 0;  x < 1; x++) {
		for(People p : peoples) {
		//	System.out.println(peoples.size());
			System.out.println("Имя:" + p.getName());
			System.out.println("Фамилия:" + p.getName2());
			System.out.println("Пол:" + (p.isPol() ? "Мужчина" : "Женщина" ));
			System.out.println("Полных лет:" + p.getYears() + ".\n--------");
		
			System.out.println("Всего людей:" + peoples.size());
		}
			
			
		
	
	
	}
	
	
	
}









