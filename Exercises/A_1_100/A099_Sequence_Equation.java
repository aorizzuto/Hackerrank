package Exercises.A_1_100;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result99 {

    /*
     * https://www.hackerrank.com/challenges/permutation-equation/problem
     */

    public static List<Integer> permutationEquation(List<Integer> p) {
        int max = p.size();

        List<Integer> ret = new ArrayList<>();

        for (int i = 1; i <= max; i++) {
            int index = p.indexOf(i)+1;
            ret.add(p.indexOf(index)+1);
        }

        return ret;
    }

}

public class A099_Sequence_Equation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result99.permutationEquation(p);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
