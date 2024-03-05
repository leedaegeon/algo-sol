import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers.length; j++){
                if(computers[i][j] == 1){
                    computers = bfs(i, j, computers);
                    answer++;
                }
            }
        }
        return answer;
    }
    public int[][] bfs(int y, int x, int[][] computers){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(y,x));
        while(!q.isEmpty()){
            Node now = q.poll();
            computers[now.y][now.x] = 0;
            
            for(int i=0; i<computers[now.x].length; i++){
                if(computers[now.x][i] == 1){
                    q.offer(new Node(now.x, i));
                }
            }
            
        }
        return computers;
    }
    class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}