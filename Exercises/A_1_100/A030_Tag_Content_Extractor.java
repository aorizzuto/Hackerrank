package Exercises.A_1_100;

/*
Sample Input
4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>

Sample Output
Nayeem loves counseling
Sanjay has no watch
So wait for a while
None
Imtiaz has a secret crush
*/

import java.util.*;
import java.util.regex.*;

public class A030_Tag_Content_Extractor{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		while(testCases>0){
			String line = in.nextLine();
            List<String> str = new ArrayList<>();

            String regex = "<(.+)>([^<]+)</\\1>";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(line);

            while (m.find()){
                str.add(m.group(2));
            }

            if (str.size() != 0){
                for (String s : str){
                    System.out.println(s);
                }
            }else{
                System.out.println("None");
            }

			testCases--;
		}

        in.close();
	}
}
