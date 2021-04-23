/*
Let's play a game on an array! You're standing at index 0 of an "n"-element array named "game". 
From some index "i", you can perform one of the following moves:
- Move Backward: If cell "i-1" exists and contains a 0, you can walk back to cell "i-1".
- Move Forward:
    - If cell "i+1" contains a zero, you can walk to cell "i+1".
    - If cell "i+leap" contains a zero, you can jump to cell "i+leap".
    - If you're standing in cell "n-1" or the value of "i+leap >= n", you can walk or jump off the end of the array and win the game.
In other words, you can move from index  to index "i+1", "i-1", or "i+leap" as long as the destination index is a cell containing a 0. 
If the destination index is greater than "n+1", you win the game.

Function Description
Complete the canWin function in the editor below. canWin has the following parameters:
    int leap: the size of the leap
    int game[n]: the array to traverse

Returns: boolean: true if the game can be won, otherwise false

Input Format
The first line contains an integer, "q", denoting the number of queries (i.e., function calls).
The "2*q" subsequent lines describe each query over two lines:
    The first line contains two space-separated integers describing the respective values of "n" and "leap".
    The second line contains "n" space-separated binary integers (i.e., zeroes and ones) describing the respective values of game0, game1,...gamen.

Sample Input
STDIN           Function
-----           --------                                            Output
4               q = 4 (number of queries)
5 3             game[] size n = 5, leap = 3 (first query)           YES
0 0 0 0 0       game = [0, 0, 0, 0, 0]
6 5             game[] size n = 6, leap = 5 (second query)          YES
0 0 0 1 1 1     game = [0, 0, 0, 1, 1, 1]
6 3             game[] size n = 6, leap = 3 (third query)           NO
0 0 1 1 1 0     game = [0, 0, 1, 1, 1, 0]
3 1             game[] size n = 3, leap = 1 (fourth query)          NO
0 1 0           game = [0, 1, 0]

Explanation

We perform the following q=4 queries:
- For game=[0,0,0,0,0] and "leap = 3", we can walk and/or jump to the end of the array because every cell contains a 0. Because we can win, we return true.
- For game=[0, 0, 0, 1, 1, 1] and leap=5, we can walk to index  and then jump  units to the end of the array. Because we can win, we return true.
For  and , there is no way for us to get past the three consecutive ones. Because we cannot win, we return false.
For  and , there is no way for us to get past the one at index . Because we cannot win, we return false.

Puedo hacerlo como un arbol con recursión
   2--4
1 /  5
  \3/
    \6
*/

import java.util.*;

public class A046_1D_Array_2 {

    static int lastIndex = 0;

    public static boolean canWin(int standIndex, int leap, int[] game) {

        if(game[standIndex] == 1) return false; 
        
        if ((standIndex == game.length - 1) || (standIndex + leap >= game.length)) return true;

        game[standIndex] = 1;
        return canWin(standIndex+1,leap,game) || canWin(standIndex+leap,leap,game) || (standIndex != 0 && canWin(standIndex-1,leap,game));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(0, leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
