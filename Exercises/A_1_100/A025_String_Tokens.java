package Exercises.A_1_100;

import java.util.Scanner;

/*
Sample Input
He is a very very good boy, isn't he?

Sample Output
10
He
is
a
very
very
good
boy
isn
t
he
*/

public class A025_String_Tokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        
        s = s.trim().replaceAll(" +", " ");

        if (s.equals("") || s.equals(" ")){
            System.out.printf("0");
        } else {

            String[] alphaOnly = s.replaceAll("[^a-zA-Z]+"," ").split(" ");

            System.out.println(alphaOnly.length);

            for (String str:alphaOnly){
                System.out.println(str);
            }
        }
        
        scan.close();
    }
}
