package Exercises.A_1_100;

/*
Your task is to create a class Prime. The class Prime should contain a single method checkPrime.
The locked code in the editor will call the checkPrime method with one or more integer arguments. 
You should write the checkPrime method in such a way that the code prints only the prime numbers.

Note: You may get a compile time error in this problem due to the statement below:
  BufferedReader br=new BufferedReader(new InputStreamReader(in));
This was added intentionally, and you have to figure out a way to get rid of the error.

Input Format
There are only five lines of input, each containing one integer.

Output Format
There will be only four lines of output. Each line contains only prime numbers depending upon the parameters passed to checkPrime in the main method of the class Solution. In case there is no prime number, then a blank line should be printed.

Sample Input
2
1
3
4
5

Sample Output

2 
2 
2 3 
2 3 5 
*/
import java.io.*;
import java.util.*;
import java.lang.reflect.*;

class Prime{
    public void checkPrime(Object... values){
    
		String str = "";
        for ( Object value : values){
            try{
				int num = (int)value;
			
				if ( num == 2 ){
					str += "2 ";
					continue;
				}
				if ( num <= 1 || num%2 == 0){
					continue;
				}

				if (check_if_prime(num)){
					str += String.valueOf(num)+" ";
				}	
			}catch(Exception e){
				continue;
			}		
        }
		
		System.out.println(str);
    }

    public static boolean check_if_prime(Integer num){

		int i = num-2;
        while (i > 1){
            if (num%i == 0){
                return false;
            }
            i -= 2;
        }
        return true;
    }
}


public class A016_Prime_Checker {

	public static void main(String[] args) {
		try{
            File initialFile = new File("//home//alejandro//test.txt");
            InputStream in = new FileInputStream(initialFile);
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			int n1=Integer.parseInt(br.readLine());
			int n2=Integer.parseInt(br.readLine());
			int n3=Integer.parseInt(br.readLine());
			int n4=Integer.parseInt(br.readLine());
			int n5=Integer.parseInt(br.readLine());
			Prime ob=new Prime();
			ob.checkPrime(n1);
			ob.checkPrime(n1,n2);
			ob.checkPrime(n1,n2,n3);
			ob.checkPrime(n1,n2,n3,n4,n5);	
			Method[] methods=Prime.class.getDeclaredMethods();
			Set<String> set=new HashSet<>();
			boolean overload=false;
			br.close();
			for(int i=0;i<methods.length;i++)
			{
				if(set.contains(methods[i].getName()))
				{
					overload=true;
					break;
				}
				set.add(methods[i].getName());
				
			}
			if(overload)
			{
				throw new Exception("Overloading not allowed");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}


