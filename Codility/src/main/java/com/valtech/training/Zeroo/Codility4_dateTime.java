package com.valtech.training.Zeroo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Codility4_dateTime {
	
	public static void main(String []args) {
		Scanner sc= new Scanner(System.in);
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("enter date s");
		LocalDateTime s=LocalDateTime.parse(sc.nextLine(),formatter);
		System.out.println("enter date e");
		LocalDateTime e=LocalDateTime.parse(sc.nextLine(),formatter);
		
		System.out.println(Duration.between(s,e).toHours());
		sc.close();
	}

}
