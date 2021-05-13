package Exercises.A_1_100;

/*
Write the following methods that return a lambda expression performing a specified action:
PerformOperation isOdd(): The lambda expression must return  if a number is odd or  if it is even.
PerformOperation isPrime(): The lambda expression must return  if a number is prime or  if it is composite.
PerformOperation isPalindrome(): The lambda expression must return  if a number is a palindrome or  if it is not.

Sample Input
The first line contains the number of test cases.
The "n" subsequent lines each describe a test case in the form of 2 space-separated integers:
    The first integer specifies the condition to check for (1 for Odd/Even, 2 for Prime, or 3 for Palindrome). 
    The second integer denotes the number to be checked.
5
1 4
2 5
3 898
1 3
2 12

Sample Output
EVEN
PRIME
PALINDROME
ODD
COMPOSITE
*/

import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd(){
        return x -> x%2==1;
    }

    public PerformOperation isPrime(){
        return x -> java.math.BigInteger.valueOf(x).isProbablePrime(1);
    }

    public PerformOperation isPalindrome(){
        return x -> String.valueOf(x).equals(new StringBuilder(String.valueOf(x)).reverse().toString());
    }
}

   // Write your code here

public class A038_Lambda_Expressions {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }
}

