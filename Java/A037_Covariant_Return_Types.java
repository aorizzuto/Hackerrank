package Java;

/*
Java allows for Covariant Return Types, which means you can vary your return type as long you are returning a subclass of your specified return type.
It is best practice to use the @Override annotation when overriding a superclass method.

Implement the classes and methods detailed in the diagram below:
https://www.hackerrank.com/challenges/java-covariance/problem?h_r=next-challenge&h_v=zen

Note: Do not use access modifiers in your class declarations.

Resources:      Covariant Return Type       Java Covariant Type

Input Format
You are not responsible for reading any input from stdin.

Output Format
Output is handled for you by the locked code, which creates the object corresponding to the input string's class name and then prints the name returned by that class' national flower's whatsYourName method. You are not responsible for printing anything to stdout.

Sample Input 0      Sample Output 0
AndhraPradesh       Lily

Explanation 0
An AndhraPradesh object's yourNationalFlower method returns an instance of the Lily class, and the Lily class' whatsYourName method returns 
Lily, which is printed by the hidden code checker.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Complete the classes below
abstract class Flower {
    public abstract String whatsYourName();
}

class Jasmine extends Flower {
    public String whatsYourName(){
        return "Jasmine";
    }
}

class Lily extends Flower {
    public String whatsYourName(){
        return "Lily";
    }
}

abstract class Region {
    public abstract Flower yourNationalFlower();
}

class WestBengal extends Region {
    public Flower yourNationalFlower(){
        return new Jasmine();
    }
}

class AndhraPradesh  extends Region {
    public Flower yourNationalFlower(){
        return new Lily();
    }
}


public class A037_Covariant_Return_Types {
  public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String s = reader.readLine().trim();
      Region region = null;
      switch (s) {
        case "WestBengal":
          region = new WestBengal();
          break;
        case "AndhraPradesh":
          region = new AndhraPradesh();
          break;
      }
      Flower flower = region.yourNationalFlower();
      System.out.println(flower.whatsYourName());
    }
}
