package Java;

/*
Using Regex, we can easily match or search for patterns in a text. Before searching, we have to specify one using some well-defined syntax.
In this problem, you are given a pattern. You have to check whether the syntax of the given pattern is valid.

Note: In this problem, a regex is only valid if you can compile it using the Pattern.compile method.

Input Format
The first line is the number of test cases. The next "n" lines contain a string of any printable characters representing the pattern 

Output Format
For each test case, print Valid if the syntax of the given pattern is correct. Otherwise, print Invalid.

Sample Input        Sample Output
3
([A-Z])(.+)         Valid
[AZ[a-z](a-z)       Invalid
batcatpat(nat       Invalid
*/

import java.util.Scanner;
import java.util.regex.*;

public class A026_Syntax_Checker
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
        String str[] = new String[testCases];
        int count = 0;

		while(testCases>0){
			String REGEX = in.nextLine();
            try{
                Pattern.compile(REGEX);
                str[count]="Valid";
            }catch(Exception e){
                str[count]="Invalid";
            }
            count += 1;
  
            testCases--;
        }

        for (String s : str){
            System.out.println(s);
        }
        in.close();
	}
}

