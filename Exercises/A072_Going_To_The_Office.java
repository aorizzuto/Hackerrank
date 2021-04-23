package Exercises;

import java.io.*;
import java.util.*;

/*
https://www.hackerrank.com/challenges/going-office/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

Output Format
Output Q lines, with each line containing the minimum distance Ms.Kox has to travel on that day. If there is no path, print "Infinity".

Sample Input
6 9             The first line of the input contains two integers N and M.
0 1 1           u , v and w, where u and v are cities connected by a bi-directional road and w is the length of this road. There is at most one road between any two cities and no road connects a city to itself.
1 2 1  
2 3 1  
3 4 1  
4 5 1  
2 4 5  
3 5 8  
1 3 3  
0 2 4  
0 5             S and D. S is the city where Ms. Kox lives and D is the city where her office is located.
9               Number of queries
0 1             u and v, where the road between u and v has been blocked that day.
1 2  
2 3  
3 4  
4 5  
2 4  
3 5  
1 3  
0 2

Sample Output
7  
6  
6  
8  
11  
5  
5  
5  
5
*/

class Road {
    private int city1;
    private int city2;
    private int distance;

    public Road(int country1, int country2, int distance) {
        this.city1 = country1;
        this.city2 = country2;
        this.distance = distance;
    }

    public int getCountry1() {
        return city1;
    }

    public int getCountry2() {
        return city2;
    }

    public int getDistance() {
        return distance;
    }
}

public class A072_Going_To_The_Office {
    private static final Scanner scan = new Scanner(System.in);
    public static int min = Integer.MAX_VALUE;
    //static Map<String,Integer> paths = new HashMap<>();   // Usar "paths" para conocer el mejor camino

    public static void main(String[] args) throws IOException {
        List<Road> roads = new ArrayList<>();
        roads.clear();

        int N = scan.nextInt();
        int M = scan.nextInt();
        
        /*** GET ROADS ***/
        for (int i = 0; i < M; i++) {
            int A = scan.nextInt();
            int B = scan.nextInt();
            int C = scan.nextInt();

            roads.add(new Road(A,B,C));
        }

        /*** GET HOME Citi and OFFICE Citi ***/
        int home = scan.nextInt();
        int office = scan.nextInt();

        /*** GET Number of Queries ***/
        int queries = scan.nextInt();

        for (int i = 0; i < queries; i++) {
            int start = scan.nextInt();         // From
            int end = scan.nextInt();           // To

            List<Road> copy = new ArrayList<>(roads);
            String citiesVisited = "";
            //paths.clear();
            min = Integer.MAX_VALUE;
            removeBreakFromRoads(copy, start,end);      // Remove Break from total roads
            searchBestRoad(citiesVisited, copy, 0, home, office);

            //int result = (int) paths.values().toArray()[0];
            int result = min;
 
            System.out.println(result);
        }        

        scan.close();
    } 

    public static void removeBreakFromRoads(List<Road> copy, int start, int end){
        for (int i = 0; i < copy.size(); i++) {
            if (copy.get(i).getCountry1() == start && copy.get(i).getCountry2() == end){
                copy.remove(i);
                break;
            }
        }
    }

    public static void searchBestRoad(String citiesVisited, List<Road> roads, int sum, int stand, int office){
        List<Road> copy = new ArrayList<>(roads);

        if (sum > min) return;

        citiesVisited += Integer.toString(stand);  // Visited

        for (int i = 0; i < roads.size(); i++) {
            Road road = roads.get(i);

            if ( road.getCountry1() == stand && citiesVisited.indexOf(Integer.toString(road.getCountry2())) == -1 && stand != office){
                copy.remove(road);
                searchBestRoad(citiesVisited, copy, sum+road.getDistance(), road.getCountry2(), office);
                if (road.getCountry2() == office) break;
            }
            else if ( road.getCountry2() == stand && citiesVisited.indexOf(Integer.toString(road.getCountry1())) == -1 && stand != office){
                copy.remove(road);
                searchBestRoad(citiesVisited, copy, sum+road.getDistance(), road.getCountry1(), office);
                if (road.getCountry1() == office) break;
            }
        }

        if (stand == office){
            //paths.clear();
            //paths.put(citiesVisited,sum);
            min = sum;
        }

        return;
    }

    // Pararse en stand y buscar "office". Sino buscar office-1, sino office-2...hasta encontrar el camino más cercano a la oficina.
}
