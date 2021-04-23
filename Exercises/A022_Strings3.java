/*
Sample Input 0
welcometojava
3

Sample Output 0
ava
wel

Explanation:
[ava, com, elc, eto, jav, ..... , wel]
*/

public class A022_Strings3 {
    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("hiwelcometojava", 3));
    }
    
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String groups[] = new String[s.length()-k+1];        

        for (int i = 0 ; i < s.length()-k+1 ; i++){
            groups[i] = s.substring(i, i+k);
        }

        int min = 0;
        int max = 0;
        for (int i = 0 ; i < groups.length - 1 ; i++){
            if ( groups[min].compareTo(groups[i+1]) > 0){
                min = i+1;
            }
            if ( groups[max].compareTo(groups[i+1]) < 0){
                max = i+1;
            }
        }

        smallest = groups[min];
        largest = groups[max];
        
        return smallest + "\n" + largest;
    }
}
