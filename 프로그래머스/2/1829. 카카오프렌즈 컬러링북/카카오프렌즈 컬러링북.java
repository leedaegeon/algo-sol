import java.util.*;
class Solution {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] map;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        map = picture;
        
        for(int i=0; i<picture.length; i++){
            for(int j=0; j<picture[i].length; j++){
                if(map[i][j] != -1){
                    if(map[i][j] != 0){
                        numberOfArea++;                    
                    }
                    int a = bfs(i,j, map[i][j]);
                    maxSizeOfOneArea = Math.max(a, maxSizeOfOneArea);
                    // System.out.println("area: " + a );
                    // for(int k=0; k<map.length; k++){
                    //     System.out.println(Arrays.toString(map[k]));
                    // }
                    // System.out.println("======================");
                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public int bfs(int y, int x, int num){
        int area = 0;
        
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(y, x));

        while(!q.isEmpty()){
            Node now = q.poll();
            if(map[now.y][now.x] == -1){
                continue;
            }
            map[now.y][now.x] = -1;
            area++;
            for(int i=0; i<4; i++){
                int nexty = now.y + dy[i];
                int nextx = now.x + dx[i];
                if(nexty<0 || nexty >= map.length 
                   || nextx < 0 || nextx >= map[0].length 
                   || map[nexty][nextx] == -1 || map[nexty][nextx] != num){
                    continue;
                }
                q.offer(new Node(nexty, nextx));
            }
        }
        if(num == 0){
            return 0;
        }
        return area;
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