package Java;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/*
Cryptographic hash functions are mathematical operations run on digital data; by comparing the computed hash to a known and expected hash 
value, a person can determine the data's integrity. 
It should be extremely difficult to produce the same hash output from two different input values using a cryptographic hash function.

Secure Hash Algorithm 2 (SHA-2) consists of six identical hashing algorithms (i.e., SHA-256, SHA-512, SHA-224, SHA-384, SHA-512/224, 
SHA-512/256) with a variable digest size. SHA-256 is a 256-bit (32 byte) hashing algorithm which can calculate a hash code for an input of 
up to 264-1 bits. It undergoes 64 rounds of hashing and calculates a hash code that is a 64-digit hexadecimal number.

Given a string, "s", print its SHA-256 hash value.

Sample 0
HelloWorld      872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4

Sample 1
Javarmi123      f1d5f8d75bb55c777207c251d07d9091dc10fe7d6682db869106aacb4b7df678
*/

public class A032_SHA_256 {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();

        byte[] bytesOfMessage = s.getBytes(StandardCharsets.UTF_8);                // Get bytes of string
        MessageDigest msgDig = MessageDigest.getInstance("SHA-256");    // Get instance of SHA-256
        
        byte[] thedigest = msgDig.digest(bytesOfMessage);           // Digest bytes

        BigInteger bigInt = new BigInteger(1,thedigest);            // Get hasg
        String hash = bigInt.toString(16);

        while (hash.length() != 64){
            hash = '0'+hash;
        }
        
        System.out.println(hash);
        
        scan.close();
    }
}
