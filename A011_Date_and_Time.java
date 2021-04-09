import java.util.Calendar;
import java.util.Date;

/*
The Calendar class is an abstract class that provides methods for converting between a specific instant in time and a set of calendar fields such as 
YEAR, MONTH, DAY_OF_MONTH, HOUR, and so on, and for manipulating the calendar fields, such as getting the date of the next week.

You are given a date. You just need to write the method which returns the day on that date. 

Complete the findDay function in the editor below.

findDay has the following parameters:
int: month
int: day
int: year

Returns
string: the day of the week in capital letters
Input Format
*/
public class A011_Date_and_Time {
 
    public enum DayOfWeek {SUNDAY, MONDAY, TUESDAY, WEDNESDAY,THURSDAY, FRIDAY, SATURDAY}

    public static String findDay(int month, int day, int year) {
        Calendar cal = Calendar.getInstance();

        cal.set(year, month-1, day, 0, 0);

        int DAY = cal.get(cal.DAY_OF_WEEK);

        return DayOfWeek.values()[DAY-1].toString();
    }

    public static void main(String[] args) {
        System.out.println(findDay(4, 3, 1986));        
    }
}
