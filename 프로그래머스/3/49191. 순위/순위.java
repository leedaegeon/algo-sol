import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];
        for(int i=0; i<graph.length; i++){
            Arrays.fill(graph[i], 987654321);
        }
        
        for(int i=0; i<results.length; i++){
            graph[results[i][0]][results[i][1]] = 1;
            graph[results[i][1]][results[i][0]] = 0;
        }
        
        for(int k=1; k<n+1; k++){
            graph[k][k] = 1;
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++){

                    if(graph[i][k] == 1  && graph[k][j] == 1 ){
                        graph[i][j] = 1;
                    }
                    if(graph[i][k] == 0  && graph[k][j] == 0 ){
                        graph[i][j] = 0;
                    }
                    
                }
            }
        }

        for(int i=1; i<graph.length; i++){
            answer += check(graph[i]);
        }
        
        return answer;
    }
    public int check(int[] graph){
        for(int i=1; i<graph.length; i++){
            if(graph[i] == 987654321){
                return 0;
            }
        }
        return 1;
    }
}