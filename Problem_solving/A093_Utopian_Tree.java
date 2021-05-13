package Problem_solving;

import java.io.*;
import java.util.stream.*;

class Result93 {

    public static int utopianTree(int n) {
        int total = 1;
        return utopianTreeRecursive(n, total);
    }

    private static int utopianTreeRecursive(int n, int total) {
        if (n == 0) return total;
        return utopianTreeRecursive(n-1, total%2==0?total+1:total*2);
    }
}

public class A093_Utopian_Tree {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result93.utopianTree(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
