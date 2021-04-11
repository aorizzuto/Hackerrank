/*
The username consists of 8 to 30 characters inclusive. If outside the range, then it is an invalid username.
The username can only contain alphanumeric characters and underscores (_). lowercase, uppercase and digits.
The first character of the username must be an alphabetic character.
For example:

Update the value of regularExpression field in the UsernameValidator class so that the regular expression only matches with valid usernames.

Sample Input 0          Sample Output 0
8
Julia                   Invalid
Samantha                Valid
Samantha_21             Valid
1Samantha               Invalid
Samantha?10_2A          Invalid
JuliaZ007               Valid
Julia@007               Invalid
_Julia007               Invalid
*/

import java.util.Scanner;

class UsernameValidator {
    
    public static final String regularExpression = "^[a-zA-Z][a-zA-Z0-9_]{7,29}+$";
}


public class A029_Username_Regular_Expression {
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }           
        }
    }
}
