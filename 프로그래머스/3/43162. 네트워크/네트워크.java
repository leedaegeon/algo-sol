import java.util.*;
class Solution {
    static Set<Integer> visited = new HashSet<>();
    
    public int solution(int n, int[][] computers) {
        int answer = 0;    
        for(int i=0; i<computers.length; i++){
            if(visited.add(i)){
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    public void dfs(int nodeNum, int[][] computers){
        
        for(int i=0; i<computers[nodeNum].length; i++){
            if(nodeNum != i && computers[nodeNum][i] == 1 && visited.add(i)){
                dfs(i, computers);
            }
        }
    }
}