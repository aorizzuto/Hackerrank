import java.util.Scanner;

/*
isAnagram has the following parameters:
string a: the first string
string b: the second string

Returns
boolean: If  and  are case-insensitive anagrams, return true. Otherwise, return false.
*/

public class A024_Anagrams {
    
    static boolean isAnagram(String a, String b) {
        
        boolean ret;
        
        a = a.toLowerCase();
        b = b.toLowerCase();
        
        if ( a.length() != b.length() ){    // If different lengths => Not anagram
            return false;
        }else{

            a = sortString(a);
            b = sortString(b);

            ret = true;

            for (int i=0;i<a.length();i++){
                if (a.charAt(i) != b.charAt(i)){
                    ret = false;
                    break;
                }
            }

            return ret;
        }
    }

    static String sortString(String str){
        int j = 0;
        char temp = 0;
        String ret = "";
        char[] chars = str.toCharArray();

        for(int i=0; i < chars.length; i++) {
            for(j=0; j < chars.length; j++) {
                if(chars[j] > chars[i]) {
                temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                }
            }
        }

        for(int i=0;i<chars.length;i++){
            ret += chars[i];
        }

        return ret;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
