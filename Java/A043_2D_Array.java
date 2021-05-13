package Java;

/*
Sample Input
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0             2 4 4
0 0 0 2 0 0               2
0 0 1 2 4 0             1 2 4

Sample Output
19
*/

import java.util.*;

public class A043_2D_Array {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
        int max = Integer.MIN_VALUE;

        for (int i = 0; i< 4; i++){
            for (int j = 0;j<4; j++){
                int new_sum = sum_of_hourglass(arr,i,j);
                if ( new_sum > max){
                    max = new_sum;
                }
            }
        }

        System.out.println(max);

        scanner.close();
    }

    public static int sum_of_hourglass(int[][] arr, int i, int j){
        return arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                           arr[i+1][j+1] + 
               arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
    }
}
