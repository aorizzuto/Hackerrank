/*
In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes 
a queue, for which elements can be added to or removed from either the front (head) or back (tail).

Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque classes. For example, deque can be declared as:

Deque deque = new LinkedList<>();       or      Deque deque = new ArrayDeque<>();

You can find more details about Deque here. https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html

In this problem, you are given N integers. You need to find the maximum number of unique integers among all the possible contiguous 
subarrays of size M.

Note: Time limit is 3 second for this problem.

Input Format
The first line of input contains two integers N and M: representing the total number of integers and the size of the subarray, respectively. 
The next line contains N space separated integers.

Constraints
M <= N
The numbers in the array will range between [0, 10.000.000].

Output Format
Print the maximum number of unique integers among all possible contiguous subarrays of size M.

Sample Input        Sample Output
6 3
5 3 5 2 3 2         3

Explanation

In the sample testcase, there are 4 subarrays of contiguous numbers.

(5,3,5) - Has 2 unique numbers.
(3,5,2) - Has 3 unique numbers. <- Max
(5,2,3) - Has 3 unique numbers. <- Max
(2,3,2) - Has 2 unique numbers.
*/

import java.util.*;
public class A039_Dequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int input = in.nextInt();

            deque.add(input);
            set.add(input);
            
            if (deque.size() == m) {            // When I get 3 records
                if (set.size() > max) {         // If my new set is grater than max (return)
                    max = set.size();           // Save my new maximum
                }             

                int first = deque.pollFirst();  // Remove first element of queue
                if (!deque.contains(first)) {   // If queue does not contain the removed element
                    set.remove(first);          // remove element from set
                }
            }
        }

        in.close();
        
        System.out.println(max);
    }
}



