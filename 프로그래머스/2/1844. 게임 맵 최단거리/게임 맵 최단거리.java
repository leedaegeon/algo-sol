import java.util.*;
class Solution {
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length-1;
        int m = maps[0].length-1;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0));
        int k=1;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                Node now = q.poll();

                if(now.y == n && now.x == m){
                    return k;
                }
                
                for(int d=0; d<4; d++){
                    int nexty = now.y + di[d];
                    int nextx = now.x + dj[d];
                    if(nexty < 0 || nexty > n || nextx < 0 || nextx > m || maps[nexty][nextx] != 1){
                        continue;
                    }
                    q.offer(new Node(nexty, nextx));
                    maps[nexty][nextx] = -1;
                }
            }
            k++;
        }
        return -1;
    }
    class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
        public String toString(){
            return "y: " + y + " x: " + x;
        }
    }
}