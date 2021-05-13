package Exercises.A_1_100;

import java.io.*;
import java.util.Arrays;

class Result5 {

    public static int countingValleys(int steps, String path) {
        int valleys = 0;
        path = path.replace("D","-1,").replace("U","1,");
        int[] level = Arrays.asList(path.split(",")).stream().mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < level.length-1 ; i++){
            level[i+1] = level[i]+level[i+1];
            if (level[i] == -1 && level[i+1] == 0) valleys++;
        }

        return valleys;
    }

}

public class A085_Counting_Valleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result5.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
