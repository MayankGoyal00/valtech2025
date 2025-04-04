package com.valtech.training.Zeroo;

import java.util.Scanner;

public class Codility3_Password {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter sen");
		String sen= sc.nextLine();
		
		int count=0;
		for(char c: sen.toCharArray()) {
			if(c=='a' || c=='e'||c== 'i' ||c== 'o' || c== 'u' || c== 'A' ||c == 'E' || c== 'I' ||c== 'O'|| c=='U') {
				count++;
			}
		}
		System.out.println(count);
		sc.close();
	}
}
