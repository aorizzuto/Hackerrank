package Exercises;

import java.io.*;
import java.text.*;
import java.util.*;

public class A071_Time_Conversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        DateFormat inputFormat = new SimpleDateFormat("hh:mm:ssaa");    
        DateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");

        Date date = null;
        String output = null;
        try{
            date= inputFormat.parse(s);         //Converting the input String to Date
            output = outputFormat.format(date); //Changing the format of date and storing it in String
        }catch(ParseException pe){
            pe.printStackTrace();
        }

        return output;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
