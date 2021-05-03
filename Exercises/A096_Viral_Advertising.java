package Exercises;

import java.io.*;

class Result96 {

    public static int viralAdvertising(int n) {
        int total=2;
        return viral(0, total, n);
    }

    private static int viral(int people, int total, int n) {
        if (n == 0) return people;
        return viral(people+total, (int) Math.floor((total*3)/2),n-1);
    }
}

public class A096_Viral_Advertising {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result96.viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

