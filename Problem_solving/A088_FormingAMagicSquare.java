package Problem_solving;

// Each row sum 15 and diagonal too.

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result6 {

    public static int[][] getMagicSquares(int side){
        /*  For side = 3
            4 9 2 | 2 9 4           8 3 4 | 4 3 8
            3 5 7 | 7 5 3           1 5 9 | 9 5 1
            8 1 6 | 6 1 8           6 7 2 | 2 7 6
            -------------           -------------
            8 1 6 | 6 1 8           6 7 2 | 2 7 6
            3 5 7 | 7 5 3           1 5 9 | 9 5 1
            4 9 2 | 2 9 4           8 3 4 | 4 3 8
        */

        // Create logic to return list of lists related to the "side" parameter
        int[][] arr = {
                        {4,9,2,3,5,7,8,1,6},{4,3,8,9,5,1,2,7,6},
                        {2,9,4,7,5,3,6,1,8},{2,7,6,9,5,1,4,3,8},
                        {8,1,6,3,5,7,4,9,2},{8,3,4,1,5,9,6,7,2},
                        {6,7,2,1,5,9,8,3,4},{6,1,8,7,5,3,2,9,4},
                    };

        return arr;
    }


    public static int formingMagicSquare(List<List<Integer>> s) {
        int[][] expectedSquare = getMagicSquares(3); // 3: side
        int[] realSquare = new int[9];

        for (int i = 0; i < s.size(); i++) {
            realSquare[i*3] = s.get(i).get(0);
            realSquare[i*3+1] = s.get(i).get(1);
            realSquare[i*3+2] = s.get(i).get(2);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < expectedSquare.length; i++) {
            int total = 0;
            for (int j = 0; j < expectedSquare[0].length; j++) {
                if( expectedSquare[i][j] != realSquare[j] ) total += Math.abs(expectedSquare[i][j] - realSquare[j]);
            }
            if (total < min) min = total;
        }
        return min;
    }

}

public class A088_FormingAMagicSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result6.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
