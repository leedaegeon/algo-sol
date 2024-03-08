import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];
        int[][] dist = new int[n+1][n+1];
        for(int i=0; i<graph.length; i++){

            Arrays.fill(graph[i], 987654321);
            
        }
        for(int i=0; i<dist.length; i++){
            Arrays.fill(dist[i],987654321);
        }
        for(int i=0; i<results.length; i++){

            graph[results[i][0]][results[i][1]] = 1;
            graph[results[i][1]][results[i][0]] = 0;
            
            dist[results[i][0]][results[i][1]] = 1;
            dist[results[i][1]][results[i][0]] = 0;
            
        }
        
        for(int k=1; k<n+1; k++){
            dist[k][k] = 1;
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++){
//                     if(k==2 && i==1 && j==5){
//                         System.out.println(graph[i][k] + " " + graph[k][j]);
                        
//                     }
                    if((graph[i][k] == 1 || dist[i][k] == 1) && (graph[k][j] == 1 || dist[k][j] == 1)){
                        dist[i][j] = 1;
                    }
                    if((graph[i][k] == 0 || dist[i][k] == 0) && (graph[k][j] == 0 || dist[k][j] == 0)){
                        dist[i][j] = 0;
                    }
                    
                }
            }
        }
//         for(int i=1; i<dist.length; i++){
//             for(int j=1; j<dist.length; j++){
//                 if(dist[i][j] == 987654321){
//                     System.out.print("_ ");
//                 }else{
//                     System.out.print(dist[i][j] + " ");
                    
//                 }
//             }
//             System.out.println();
//         }
        for(int i=1; i<dist.length; i++){
            answer += check(dist[i]);
        }
        
        return answer;
    }
    public int check(int[] dist){
        for(int i=1; i<dist.length; i++){
            if(dist[i] == 987654321){
                return 0;
            }
        }
        return 1;
    }
}