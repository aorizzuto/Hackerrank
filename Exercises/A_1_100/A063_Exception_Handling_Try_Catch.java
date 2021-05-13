package Exercises.A_1_100;

import java.util.Scanner;

/*
You will be given two integers as input, you have to compute a/b. If a and b are not 32 bit signed integers or if  is zero, 
exception will occur and you have to report it. Read sample Input/Output to know what to report in case of exceptions.

Sample Input 0:         Output
10                      3
3

10                      java.util.InputMismatchException
Hello

10                      java.lang.ArithmeticException: / by zero
0

23.323                  java.util.InputMismatchException
0
*/

public class A063_Exception_Handling_Try_Catch {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int a = 0,b = 0;
        try{
            a = scan.nextInt();
            b = scan.nextInt();

            try{
                System.out.println(a/b);
            }catch(Exception e){
                System.out.println(e);
            }
        }catch(Exception e){
            System.out.println("java.util.InputMismatchException");
        }

        scan.close();        
    }
}
