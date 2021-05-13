package Problem_solving;

import java.io.*;

class Result95 {

    public static int beautifulDays(int i, int j, int k) {
        int total = 0;
        for (int k2 = i; k2 < j+1; k2++)
            if ((k2 - reverse(0, k2))%k == 0) total++;
        
        return total;
    }

    static int reverse(int rev, int n){
        if(n<=0) return rev;
        return reverse((rev*10) + n%10, n/10);
    }
}

public class A095_Beautiful_Days_at_the_Movies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result95.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
