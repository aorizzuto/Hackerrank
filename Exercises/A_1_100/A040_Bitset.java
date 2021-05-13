package Exercises.A_1_100;

/*
Java BitSet
Java's BitSet class implements a vector of bit values that grows as needed, allowing us to easily manipulate bits while optimizing space. 
Any element having a bit value of 1 is called a set bit.
Given 2 BitSets, B1 and B2, of size N where all bits in both BitSets are initialized to 0, perform a series of M operations. 
After each operation, print the number of set bits in the respective BitSets as two space-separated integers on a new line.

Input Format
The first line contains 2 space-separated integers:
    N (the length of both BitSets B1 and B2)
    M (the number of operations to perform), respectively.

The  subsequent lines each contain an operation in one of the following forms: 
    AND, OR, XOR with <set> <set> as arguments
    FLIP, SET with <set> <index> as arguments

In the list above, <set> is the integer B1 or B2. <index> is an integer denoting a bit's index in the BitSet corresponding to <set>.

For the binary operations AND, OR, and XOR, operands are read from left to right and the BitSet resulting from the operation replaces 
the contents of the first operand. For example: AND 2 1
B2 is the left operand, and B1 is the right operand. This operation should assign the result of B2^B1 to B2.

Output Format
After each operation, print the respective number of set bits in BitSet B1 and BitSet B2 as 2 space-separated integers on a new line.

Sample 
5 4         
AND 1 2     0 0
SET 1 4     1 0
FLIP 2 2    1 1
OR 2 1      1 2

Explanation
https://www.hackerrank.com/challenges/java-bitset/problem?h_r=next-challenge&h_v=zen

*/
import java.util.*;

public class A040_Bitset {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int B1B2 = scan.nextInt();
        final int numOfOperations = scan.nextInt();

        BitSet B1_2[] = new BitSet[2];
        B1_2[0] = new BitSet(B1B2);
        B1_2[1] = new BitSet(B1B2);

        for (int i = 0 ; i < numOfOperations ; i++){
            String operation = scan.next(); // Operation
            int B1count=0;
            int B2count=0;
            int a = scan.nextInt();         // set
            int b = scan.nextInt();         // set/index

            switch(operation){
                case "AND":   B1_2 = Operations.AND(B1_2, a, b); break;
                case "SET":   B1_2 = Operations.SET(B1_2, a, b); break;
                case "FLIP":  B1_2 = Operations.FLIP(B1_2, a, b); break;
                case "OR":    B1_2 = Operations.OR(B1_2, a, b); break;
                case "XOR":   B1_2 = Operations.XOR(B1_2, a, b); break;
            }

            
            for (int j = B1_2[0].nextSetBit(0); j >= 0; j = B1_2[0].nextSetBit(j+1)) {
                B1count++;
            }
            for (int j = B1_2[1].nextSetBit(0); j >= 0; j = B1_2[1].nextSetBit(j+1)) {
                B2count++;
            }
            
            System.out.println(B1count + " " + B2count);

        }

        scan.close();
    }
}

class Operations {

    static Map<Integer, BitSet> map = new HashMap<>();
    
    public static BitSet[] AND(BitSet B1_2[], int a, int b){
        B1_2[a-1].and(B1_2[b-1]);
        return B1_2;
    }

    public static BitSet[] SET(BitSet B1_2[], int a, int b){        
        B1_2[a-1].set(b);
        return B1_2;
    }

    public static BitSet[] FLIP(BitSet B1_2[], int a, int b){        
        B1_2[a-1].flip(b);
        return B1_2;
    }

    public static BitSet[] OR(BitSet B1_2[], int a, int b){        
        B1_2[a-1].or(B1_2[b-1]);
        return B1_2;
    }

    public static BitSet[] XOR(BitSet B1_2[], int a, int b){        
        B1_2[a-1].xor(B1_2[b-1]);
        return B1_2;
    }
}

/*
366 100								10 50
SET 1 136		1 0                AND 1 2     0 0
OR 2 1              1 1                XOR 1 2     0 0 
OR 2 1              1 1                XOR 1 2     0 0 
FLIP 2 98          1 2                AND 2 1     0 0 
AND 2 1            1 1                XOR 1 2     0 0 
XOR 1 2            0 1               SET 1 1     1 0
SET 2 153         0 2               SET 1 0     2 0
XOR 1 2            2 2               XOR 2 1     2 2
XOR 1 2            0 2               OR 1 2      2 2
OR 1 2              2 2                FLIP 2 1    2 1 
FLIP 2 193        2 3                OR 2 1      2 2
AND 1 2            2 3                FLIP 1 4    3 2 
OR 2 1              2 3                AND 1 2     2 2 
AND 2 1            2 2                OR 1 2      2 2 
SET 2 363         2 3               OR 2 1      2 2
SET 1 116         3 3               XOR 1 2     0 2
AND 2 1            3 2                SET 1 3     1 2 
FLIP 2 298        3 3                AND 1 2     0 2
AND 2 1            3 2                SET 2 8     0 3 
SET 1 147         4 2               OR 1 2      3 3
FLIP 2 332        4 3                AND 1 2     3 3
XOR 2 1            4 3               AND 1 2     3 3
OR 1 2              5 3                XOR 2 1     3 0 
XOR 2 1            5 2               AND 2 1     3 0
FLIP 1 209        6 2                XOR 1 2     3 0
FLIP 1 292        7 2                SET 2 5     3 1
FLIP 1 302        8 2                OR 1 2      4 1
FLIP 1 131        9 2                XOR 2 1     4 3
FLIP 1 91          10 2              XOR 1 2     1 3
AND 2 1            10 2              AND 1 2     0 3
OR 1 2              10 2              FLIP 2 2    0 4
FLIP 2 11          10 3              AND 1 2     0 4
OR 2 1              10 11            AND 1 2     0 4
FLIP 1 210        11 11            XOR 1 2     4 4
SET 1 67           12 11            XOR 2 1     4 0 
XOR 2 1            12 3              AND 1 2     0 0 
SET 2 324         12 4              FLIP 1 0    1 0 
OR 1 2              14 4              SET 2 0     1 1
AND 1 2            4 4                OR 2 1      1 1 
AND 2 1            4 4                FLIP 2 9    1 2 
FLIP 1 149        5 4                XOR 1 2     1 2
XOR 2 1            5 1               FLIP 2 8    1 3
FLIP 2 331        5 2                AND 1 2     1 3
SET 1 37           6 2               XOR 2 1     1 2
SET 2 346         6 3               AND 2 1     1 0
XOR 1 2            7 3               XOR 1 2     1 0
SET 2 322         7 4               AND 1 2     0 0
OR 2 1              7 9                SET 1 4     1 0 
OR 2 1              7 9                XOR 1 2     1 0 
OR 1 2              9 9                AND 2 1     1 0 
FLIP 1 130        10 9
XOR 2 1            10 1
OR 2 1              10 10
OR 1 2              10 10
FLIP 2 229        10 11
FLIP 2 105        10 12
OR 2 1              10 12
FLIP 1 91          11 12
OR 2 1              11 13
AND 1 2            11 13
XOR 2 1            11 2

*/