package Exercises.A_1_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Sample Input
5
12 0 1 78 12
2
Insert
5 23
Delete
0

Sample Output
0 1 78 12 23

Explanation
L = [12 0 1 78 12]
Q0 = Insert 23 at index 5.
Q1 = Delete the element at index 0.

Having performed all  queries, we print  as a single line of space-separated integers.
*/

public class A047_List {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        
        int n = scan.nextInt();

        for (int i=0;i<n;i++){
            list.add(scan.nextInt());
        }
        
        n = scan.nextInt();

        for (int i=0;i<n;i++){
            String text = scan.next();

            int index = 0;

            switch(text.toUpperCase()){
                case "INSERT": 
                    index = scan.nextInt();
                    int num = scan.nextInt();
                    list.add(index, num); 
                    break;
                case "DELETE": 
                    index = scan.nextInt();
                    list.remove(index);
                    break;
                default:
                    break;
            }
        }

        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }

        scan.close();
    }
}
