package Exercises;

import java.util.*;

/*
proportion of positive values
proportion of negative values
proportion of zeros

Sample Input
STDIN           Function
-----           --------
6
-4 3 -9 0 4 1

Sample Output
0.500000
0.333333
0.166667
*/

public class A067_Plus_Minus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int positive = 0, negative = 0, zeros = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)         positive += 1;
            else if (arr[i] < 0)    negative += 1;
            else                    zeros += 1;
        }

        int len = arr.length;
        System.out.println((double) positive/len);
        System.out.println((double) negative/len);
        System.out.println((double) zeros/len);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
