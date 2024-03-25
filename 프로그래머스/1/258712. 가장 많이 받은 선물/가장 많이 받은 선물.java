import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> name = new HashMap<>();
        int[][] adj = new int[friends.length][friends.length];
        int[] rank = new int[friends.length];
        
        for(int i=0; i<friends.length; i++){
            name.put(friends[i], i);
        }
        for(int i=0; i<gifts.length; i++){
            String[] gift = gifts[i].split(" ");
            int a = name.get(gift[0]);
            int b = name.get(gift[1]);
            adj[a][b] += 1;
        }
        
        for(int i=0; i<friends.length; i++){
            for(int j=0; j<friends.length; j++){
                rank[i] += adj[i][j];
                rank[i] -= adj[j][i];
            }
        }
        for(int i=0; i<friends.length; i++){
            int k=0;
            for(int j=0; j<friends.length; j++){
                if(i==j){
                    continue;
                }
                if(adj[i][j] > adj[j][i]){
                    k++; 
                }else if(adj[i][j] == adj[j][i] && rank[i] > rank[j]){
                    k++;
                }
                
            }
            answer = Math.max(answer, k);
        }
        
        return answer;
    }
}