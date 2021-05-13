package Exercises.A_1_100;

/*
https://www.hackerrank.com/challenges/apple-and-orange/problem?h_r=next-challenge&h_v=zen
*/

import java.util.*;

public class A074_Apple_and_Orange {

    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int startHouse, int endHouse, int appleTree, int orangeTree, int[] apples, int[] oranges) {
        int sumApples = 0, sumOranges = 0;
        
        for (int i = 0; i < apples.length; i++)     apples[i] = apples[i]+appleTree;
        for (int i = 0; i < oranges.length; i++)    oranges[i] = oranges[i]+orangeTree;

        for (int i = 0; i < apples.length; i++)     if (apples[i] >= startHouse && apples[i] <= endHouse)     sumApples++;
        for (int i = 0; i < oranges.length; i++)    if (oranges[i] >= startHouse && oranges[i] <= endHouse)   sumOranges++;

        System.out.println(sumApples);
        System.out.println(sumOranges);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }
}
