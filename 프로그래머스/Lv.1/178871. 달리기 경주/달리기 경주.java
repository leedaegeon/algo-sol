import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        Map<String, Integer> scores = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            scores.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++){
            String exist = players[scores.get(callings[i])-1];
            // System.out.println(exist);
            players[scores.get(callings[i])-1] = callings[i];
            players[scores.get(callings[i])] = exist;
            scores.put(callings[i], scores.get(callings[i])-1);
            scores.put(exist, scores.get(exist)+1);
        }
        // System.out.println("----------------------");
        // for(Map.Entry m: scores.entrySet()){
        //     System.out.println(m.getKey() + " " + m.getValue());
        // }
        
        return players;
    }
    
}