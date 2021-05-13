package Java;

/*
A prime number is a natural number greater than  whose only positive divisors are  and itself. 

Given a large integer, use the Java BigInteger class' isProbablePrime method to determine and print whether it's prime or not prime.

Input Format
A single line containing an integer (the number to be checked).

Output Format
If it is a prime number, print prime; otherwise, print not prime.

Sample Input
13

Sample Output
prime
*/

import java.math.*;
import java.util.*;

public class A061_Primality_test {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();

        BigInteger bigint = new BigInteger(n);

        System.out.println(bigint.isProbablePrime(1)? "prime":"not prime");

        scanner.close();
    }
}