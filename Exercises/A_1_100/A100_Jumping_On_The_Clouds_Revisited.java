package Exercises.A_1_100;

import java.io.*;
import java.util.*;

public class A100_Jumping_On_The_Clouds_Revisited {

    // https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem?h_r=next-challenge&h_v=zen

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {

        int life = 100;
        int len = c.length;
        int position = 0;
        boolean notDone=true;

        while(notDone){
            position += k; // jump
            life -= 1; // life - 1

            if (position >= len) position -= len;
            if (c[position] == 1) life -= 2;    // If could -> life - 2
            if (position == 0) notDone=false;   // If return to 0 -> break loop
        }

        return life;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

