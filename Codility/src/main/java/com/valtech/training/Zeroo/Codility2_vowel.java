package com.valtech.training.Zeroo;

import java.util.Scanner;

public class Codility2_vowel {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter sen");
		String sen=sc.nextLine().toLowerCase();
		
		int vcount=0;
		for(char c: sen.toCharArray()) {
			if("aeiou".indexOf(c)!=-1) {
				vcount++;
			}
		}
		System.out.println(vcount);
		sc.close();
	}

}
