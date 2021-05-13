package Exercises.A_1_100;

// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result8 {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        createMapWithRanking(map, ranked);
        
        return getRankingFromPlayers(map, player);
    }

    private static List<Integer> getRankingFromPlayers(Map<Integer, Integer> map, List<Integer> player) {
        List<Integer> ranking = new ArrayList<>();
        int num_to_pop;
        boolean found;

        for (Integer game : player) {
            num_to_pop = 0;
            found = false;

            for (int i = 0; i < map.size(); i++) {
                if ( map.get(map.size()-i) > game){
                    ranking.add(map.size()-i+1);
                    found = true;
                    break;
                }
                num_to_pop++;
            }
            
            if (!found) ranking.add(1);

            for (int i = 0; i < num_to_pop; i++) {
                map.remove(map.size());
            }
        }
        return ranking;
    }

    public static void createMapWithRanking(Map<Integer,Integer> map, List<Integer> ranked){
        // Creation of Map (rank, ranked)
        
        int value = 1;
        int latest = ranked.get(0);

        for (int i = 0; i < ranked.size(); i++) {            
            if ( ranked.get(i) != latest){
                value += 1;
                latest = ranked.get(i);
            }
            map.put(value,ranked.get(i));
        }
    }
}

public class A090_Climbing_the_Leaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result8.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
