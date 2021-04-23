import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
Given a double-precision number, "payment", denoting an amount of money, use the NumberFormat class' getCurrencyInstance method to convert it into 
the US, Indian, Chinese, and French currency formats. Then print the formatted values as follows:

US: formattedPayment
India: formattedPayment
China: formattedPayment
France: formattedPayment

where "formattedPayment" is "payment" formatted according to the appropriate Locale's currency.

Note: India does not have a built-in Locale, so you must construct one where the language is en (i.e., English).

Input Format
A single double-precision number denoting "payment".

Output Format
On the first line, print US: u where  is  formatted for US currency.
On the second line, print India: i where  is  formatted for Indian currency.
On the third line, print China: c where  is  formatted for Chinese currency.
On the fourth line, print France: f, where  is  formatted for French currency.

Sample Input

12324.134
Sample Output

US: $12,324.13
India: Rs.12,324.13
China: ￥12,324.13
France: 12 324,13 €
*/
public class A012_Currency_Formatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        Locale indiaLocale = new Locale("en", "IN");
               
        NumberFormat us = NumberFormat.getInstance(Locale.US);
        NumberFormat india = NumberFormat.getInstance(indiaLocale);
        NumberFormat china = NumberFormat.getInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getInstance(Locale.FRANCE);

        System.out.println("US: $" + us.format(payment));
        System.out.println("India: Rs." + india.format(payment));
        System.out.println("China: ￥" + china.format(payment));
        System.out.println("France: " + france.format(payment) + " €");
    }
}
