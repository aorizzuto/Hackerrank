package Exercises.A_1_100;

import java.util.Scanner;

/*
The challenge here is to read "n" lines of input until you reach EOF, then number and print all "n" lines of content.
Hint: Java's Scanner.hasNext() method is helpful for this problem.

Sample Input
Hello world
I am a file
Read me until end-of-file.

Sample Output
1 Hello world
2 I am a file
3 Read me until end-of-file.
*/
public class A008_EndOfFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while(scan.hasNext()){
            i++;
            System.out.println(i + " " + scan.nextLine());
        }

        scan.close();
    }
}
