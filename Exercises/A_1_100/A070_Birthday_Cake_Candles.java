package Exercises.A_1_100;

/*
Return
int: the number of candles that are tallest

Sample Input 0
4
3 2 1 3

Sample Output 0
2
*/

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result1 {

    public static int birthdayCakeCandles(List<Integer> candles) {
    // Write your code here
    Collections.sort(candles);
    int occurrences = Collections.frequency(candles, candles.get(candles.size()-1));
    return occurrences;
    }

}

public class A070_Birthday_Cake_Candles {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());
        Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result1.birthdayCakeCandles(candles);

        System.out.println(result);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedReader.close();
        // bufferedWriter.close();
    }
}

