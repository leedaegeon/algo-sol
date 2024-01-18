import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[y+1];
        
        q.offer(x);
        int cnt = 0;
        while(!q.isEmpty()){
            int qsize = q.size();
            
            for(int i=0; i<qsize; i++){
                int current = q.poll();
                // visited[current] = true;
                // System.out.println(current + " " + cnt);
                if(current == y){
                    return cnt;
                }
                if(current+n <= y && !visited[current+n]){
                    q.offer(current+n);
                    visited[current+n] = true;
                }
                if(current*2 <= y && !visited[current*2]){
                    q.offer(current*2);
                    visited[current*2] = true;
                }
                if(current*3 <= y && !visited[current*3]){
                    q.offer(current*3);
                    visited[current*3] = true;
                }
            }
            cnt++;
        }
        
        
        return answer;
    }
}