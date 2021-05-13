package Exercises.A_1_100;

import java.util.Scanner;

/*
Input Format
Every line of input will contain a String followed by an integer.
Each String will have a maximum of 10 alphabetic characters, and each integer will be in the inclusive range from 0 to 999.

Output Format
In each line of output there should be two columns:
The first column contains the String and is left justified using exactly 15 characters.
The second column contains the integer, expressed in exactly 3 digits; if the original input has less than three digits, pad leading digits with zeroes.
*/

public class A004_Java_Output_Formatting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();
            
            System.out.print(String.format("%-" + 15 + "s", s1));
            System.out.println(String.format("%03d", x));
        }
        sc.close();
        System.out.println("================================");
    }
}
