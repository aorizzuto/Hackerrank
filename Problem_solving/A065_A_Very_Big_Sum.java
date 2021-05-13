package Problem_solving;

import java.io.*;
import java.math.*;
import java.util.*;

public class A065_A_Very_Big_Sum {

    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {
        BigInteger bi = new BigInteger("0");

        for (int i = 0; i < ar.length; i++) {
            bi = bi.add(new BigInteger(Long.toString(ar[i])));
        }

        return bi.longValue();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] ar = new long[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            long arItem = Long.parseLong(arItems[i]);
            ar[i] = arItem;
        }

        long result = aVeryBigSum(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
