package com.valtech.training.Zeroo;

import java.util.Scanner;

public class Codility5_mobile {
    public static int mobilephone(String number) {
        if (number== null|| number.length()!=10|| !number.matches("\\d+")){
            return 1;
        }
        int rate=0;
        if(isAllDigitsSame(number)){
            return 10;  
        }
        if (isConsecutiveSequence(number)){
            rate +=8;
        }
        if (containsPartialSequence(number)) {
            rate +=6;
        }
        if (containsFamiliarPatterns(number)) {
            rate +=7;
        }
        if (hasRepeatingGroups(number)) {
            rate +=5;
        }
        if (rate == 0) {
            rate = 2; 
        }
        return Math.max(1,Math.min(rate, 10));
    }

    private static boolean isAllDigitsSame(String number) {
        char firstDigit = number.charAt(0);
        for(int i=1; i <number.length(); i++){
            if(number.charAt(i)!= firstDigit){
                return false;
            }
        }
        return true;
    }

    private static boolean isConsecutiveSequence(String number) {
        for (int i = 0; i <number.length() - 1; i++) {
            if (Math.abs(number.charAt(i)-number.charAt(i+1))!= 1) {
                return false;
            }
        }
        return true;
    }
   
    
    private static boolean containsPartialSequence(String number) {
        for (int i = 0; i < number.length() / 2; i++) {
            String firstPart = number.substring(0, i + 1);
            String secondPart = number.substring(i + 1, i + firstPart.length() + 1);
            if (firstPart.equals(secondPart)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsFamiliarPatterns(String number) {
        String[] commonPatterns = {
            "111","222","333","444","555","666","777","800","888","900","999","123","234","000"
        };
        for (String pattern : commonPatterns) {
            if (number.contains(pattern)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasRepeatingGroups(String number) {
        String group1 = number.substring(0, 3);
        String group2 = number.substring(3, 6);
        String group3 = number.substring(6, 10);
        return group1.equals(group2)||group1.equals(group3)|| group2.equals(group3);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter phone number");
        String mobileNumber = sc.nextLine();  
        sc.close();
        int rate = mobilephone(mobileNumber);
        System.out.println("phone number rate "+rate);
    }
}

   