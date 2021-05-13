package Problem_solving;

/*
Sample Input
2 3
2 4
16 32 96

Sample Output
3

Explanation
2 and 4 divide evenly into 4, 8, 12 and 16.
4, 8 and 16 divide evenly into 16, 32, 96.
4, 8 and 16 are the only three numbers for which each element of a is a factor and each is a factor of all elements of b.
*/

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result3 {

    static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    static List<Integer> getAllDivisors(List<Integer> num) {
        int g = num.get(0);
        HashSet<Integer> divisors = new HashSet<Integer>();
    
        for (int i = 1; i < num.size(); i++) g = gcd(num.get(i), g); // GCD = g
    
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                divisors.add(i);
                if (g / i != i) divisors.add(g / i);
            }
        }
    
        return new ArrayList<Integer>(divisors);
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int total = 0;
        List<Integer> divisors = new ArrayList<>();
        boolean flag;

        divisors = getAllDivisors(b);

        for ( Integer divisor : divisors){
            flag = true;
            for ( Integer element : a){
                if ( divisor % element != 0){
                    flag = false;
                    break;
                }
            }
            if (flag) total++;
        }
        return total;
    }
}

public class A076_Between_Two_Sets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        Integer.parseInt(firstMultipleInput[0]);

        Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result3.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
