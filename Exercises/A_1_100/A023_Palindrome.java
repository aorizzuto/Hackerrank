package Exercises.A_1_100;

import java.util.Scanner;

// Given a string , print Yes if it is a palindrome, print No otherwise.
public class A023_Palindrome {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B="";

        for (int i=A.length()-1;i>=0;i--) B+=A.charAt(i);

        System.out.println(A.equals(B)?"Yes":"No");

        sc.close();
    }
}
