package Exercises;

/*
Sample Input
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5

Sample Output
74
52
37
ERROR!
ERROR!

Explanation
https://www.hackerrank.com/challenges/java-arraylist/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
*/

import java.util.*;

public class A045_ArrayList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, List<Integer>> map = new HashMap<>();

        int numberOfLists = Integer.parseInt(scan.nextLine());

        for (int i=0 ; i<numberOfLists ; i++){
            int numberOfElements = scan.nextInt();
            map.put(i+1, new ArrayList<Integer>());

            for (int j=0 ; j<numberOfElements ; j++){
                int element = Integer.parseInt(scan.next());
                map.get(i+1).add(element);
            }
        }

        int numberOfRequests = scan.nextInt();

        for (int i=0 ; i<numberOfRequests ; i++){
            int listNumber = scan.nextInt();
            int listIndex = scan.nextInt();

            try{
                System.out.println(map.get(listNumber).get(listIndex-1));
            }
            catch (Exception e){
                System.out.println("ERROR!");
            }
        }

        scan.close();

    }
}
