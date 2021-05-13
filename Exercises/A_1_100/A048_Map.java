package Exercises.A_1_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Sample Input
3
uncle sam
99912222
tom
11122222
harry
12299933

uncle sam
uncle tom
harry

Sample Output
uncle sam=99912222
Not found
harry=12299933
*/

public class A048_Map {
    public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
        Map<String,Integer> map = new HashMap<>();

		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			in.nextLine();
            map.put(name,phone);
		}

		while(in.hasNext())
		{
			String s=in.nextLine();

            Integer phone = map.get(s);

            if (phone != null){
                System.out.println(s+"="+phone);
            }else{
                System.out.println("Not found");
            }

		}

        in.close();
	}
}
