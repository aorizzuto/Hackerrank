package Exercises.A_1_100;

/*
Java's BigDecimal class can handle arbitrary-precision signed decimal numbers. Let's test your knowledge of them!

Given an array, "s", of "n" real number strings, sort them in descending order. 
Each number must be printed in the exact same format as it was read from stdin, meaning that ".1" is printed as ".1", and 0.1 is printed as 0.1. 

You must rearrange array s's elements according to the instructions above.

Input Format
The first line consists of a single integer, "n", denoting the number of integer strings.
Each line "i" of the "n" subsequent lines contains a real number denoting the value of "si".

Output Format
You are only responsible for reordering the array's elements.

Sample Input        Sample Output
9                   90
-100                56.6
50                  50
0                   02.34
56.6                0.12
90                  .12
0.12                0
.12                 000.000
02.34               -100
000.000             
*/

import java.math.BigDecimal;
import java.util.*;

public class A060_BigDecimal {
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if(a == null || b == null) return 0;
        
                BigDecimal bd_a = new BigDecimal(a);
                BigDecimal bd_b = new BigDecimal(b);
                
                return bd_b.compareTo(bd_a);
            }
        });

        // Other option is use "map" to order "s" like <Integer, BigDecimal>

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
