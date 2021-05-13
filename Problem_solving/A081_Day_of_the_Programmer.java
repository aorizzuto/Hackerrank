package Problem_solving;


import java.io.*;

public class A081_Day_of_the_Programmer {

    static boolean isLeap(int year){
        if (year < 1919)
            return year % 4 == 0;   // Julian calendar
        return (year%4 == 0 && year%100 == 0 && year%400 == 0) || (year%4 == 0 && year%100 != 0); // Gregorian calendar
    }
    
    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        if (year == 1918) return "26.09.1918";
        return (isLeap(year))? "12.09."+Integer.toString(year):"13.09."+Integer.toString(year);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

