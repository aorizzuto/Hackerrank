package Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
We use the integers a, b, and n to create the following series:

a + (2^x)*b,    con x desde 0 hasta n

Input Format

The first line contains an integer, "q", denoting the number of queries.
Each line "i" of the "q" subsequent lines contains three space-separated integers describing the respective "a", "b" and "q" values for that query.

Constraints
1 <= n <= 15

Output Format
For each query, print the corresponding series on a new line. Each series must be printed in order as a single line of  space-separated integers.
*/

public class A006_Loops2 {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int q = in.nextInt(); // queries
        List<String> queries = new ArrayList<>();

        in.nextLine();

        for(int i=0;i<q;i++){
            String str = in.nextLine();
            queries.add(str);
        }

        for(String query:queries){
            int a = Integer.parseInt(query.split(" ")[0]);
            int b = Integer.parseInt(query.split(" ")[1]);
            int n = Integer.parseInt(query.split(" ")[2]);
            
            int num = 0;

            for(int i=0;i<n;i++){
                num += (int) Math.round(Math.pow(2,i))*b;
                System.out.printf("%d ",a+num);
            }
            System.out.println();
        }
        in.close();
    }
}
