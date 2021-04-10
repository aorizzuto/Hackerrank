import java.util.Scanner;

/*
Given two strings of lowercase English letters, A and B, perform the following operations:

* Sum the lengths of A and B.
* Determine if A is lexicographically larger than B (i.e.: does B come before A in the dictionary?).
* Capitalize the first letter in A and B and print them on a single line, separated by a space.

Sample Input 0
hello
java

Sample Output 0
9
No
Hello Java
*/

public class A020_Strings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        String A=sc.next();
        String B=sc.next();

        System.out.println(A.length()+B.length());
        if(A.compareToIgnoreCase(B) <= 0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
        A = A.toUpperCase().charAt(0) + A.toLowerCase().substring(1,A.length());
        B = B.toUpperCase().charAt(0) + B.toLowerCase().substring(1,B.length());

        System.out.println(A + " " + B);
    }
}
