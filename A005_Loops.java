import java.util.Scanner;

/*
Task
Given an integer, N, print its first 10 multiples. Each multiple N x i (where 1<i<10) should be printed on a new line in the form: N x i = result.

Input Format
A single integer, .

Constraints
2 < N < 20

Output Format
Print 10 lines of output; each line i (where 1<i<10)
N x i = result.
*/
public class A005_Loops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for (int i=0 ; i<10 ; i++)
        {
            System.out.printf("%d x %d = %d\n",N,i+1,N*(i+1));
        }

        scanner.close();
    }
}
