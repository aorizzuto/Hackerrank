package Exercises.A_1_100;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-negative-subarray/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

public class A044_Subarray {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String arr_str[] = scan.nextLine().split(" ");

        int arr[] = new int[n];

        for (int j = 0; j < n; j++) {
            int arrItem = Integer.parseInt(arr_str[j]);
            arr[j] = arrItem;
        }

        int total = 0;
        for (int i = 0; i<n;i++){
            for (int j = i; j<n ; j++){
                if (Arrays.stream(Arrays.copyOfRange(arr, i, j + 1)).sum() < 0){
                    total += 1;
                }
            }
        }

        scan.close();

        System.out.println(total);
    }
}
