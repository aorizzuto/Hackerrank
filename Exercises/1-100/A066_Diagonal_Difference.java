package Exercises;

/*
Sample Input
3
11 2 4
4 5 6
10 8 -12

Sample Output
15

Explanation
Sum across the primary diagonal: 11 + 5 - 12 = 4
Sum across the secondary diagonal: 4 + 5 + 10 = 19
Difference: |4 - 19| = 15
*/

import java.io.*;
import java.util.*;

class Result {

    public static int diagonalDifference(List<List<Integer>> arr) {
        List<Integer> firstDiagonal = new ArrayList<>();
        List<Integer> secondDiagonal = new ArrayList<>();

        int len = arr.get(0).size(); // All rows have same length

        for (int i = 0; i < len; i++) {
            firstDiagonal.add(arr.get(i).get(i));
            secondDiagonal.add(arr.get(i).get(len - 1 - i));
        }

        int a = firstDiagonal.stream().mapToInt(num -> num).sum();
        int b = secondDiagonal.stream().mapToInt(num -> num).sum();

        return Math.abs(a-b);
    }

}

public class A066_Diagonal_Difference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        Result.diagonalDifference(arr);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedReader.close();
        //bufferedWriter.close();
    }
}
