package Exercises.A_1_100;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/*
MD5 (Message-Digest algorithm 5) is a widely-used cryptographic hash function with a 128-bit hash value. 
Here are some common uses for MD5: To store a one-way hash of a password or To provide some assurance that a transferred file has arrived intact.
The CMU Software Engineering Institute essentially considers MD5 to be "cryptographically broken and unsuitable for further use".

Given an alphanumeric string "s", compute and print its MD5 encryption value.

Constraints
6 <= s <= 20

Sample Input 0      Sample Output 0
HelloWorld          68e109f0f40ca72a15e05cc22786f8e6

Sample Input 1      Sample Output 1
Javarmi123          2da2d1e0ce7b4951a858ed2d547ef485
*/

public class A031_Java_MD5 {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();

        byte[] bytesOfMessage = s.getBytes("UTF-8");                // Get bytes of string
        MessageDigest msgDig = MessageDigest.getInstance("MD5");    // Get instance of MD5
        
        byte[] thedigest = msgDig.digest(bytesOfMessage);           // Digest bytes

        BigInteger bigInt = new BigInteger(1,thedigest);            // Get hasg
        String hash = bigInt.toString(16);

        System.out.println(hash);       
        
        scan.close();
    }
}
