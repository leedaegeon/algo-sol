import java.util.*;
class Solution {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] costs = {100, 500};
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        
        int[][][] roadCost = new int[n][n][4];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(roadCost[i][j], 987654321);
            }
        }
        
        Queue<Car> cars = new ArrayDeque<>();
        if(board[0][1] == 0){
            cars.offer(new Car(0, 0, 0, 1));   
            roadCost[0][0][1] = 0;
        }
        if(board[1][0] == 0){
            cars.offer(new Car(0, 0, 0, 2));
            roadCost[0][0][2] = 0;
            
        }
        
        
        while(!cars.isEmpty()){
            Car now = cars.poll();
            if(now.y == n-1 && now.x == n-1){
                answer = Math.min(answer, now.cost);
                continue;
            }
            for(int i=0; i<4; i++){
                int nexty = now.y + dy[i];
                int nextx = now.x + dx[i];
                if(nexty < 0 || nexty >= n || nextx < 0 || nextx >= n || board[nexty][nextx] == 1){
                    continue;
                }
                int cost;
                if(((now.dir&1) == 0 && (i&1) == 0) || ((now.dir&1) == 1 && (i&1) == 1)) {
                    cost = costs[0];
                }else{
                    cost = costs[0] + costs[1];
                }

                if(roadCost[nexty][nextx][i] > now.cost + cost){
                    roadCost[nexty][nextx][i] = now.cost + cost;
                    cars.offer(new Car(nexty, nextx, now.cost + cost, i));
                }
            }
        }

        return answer;
    }
    
    class Car{
        int y;
        int x;
        int cost;
        int dir;
        Car(int y, int x, int cost, int dir){
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.dir = dir;
        }
        public String toString(){
            return "{y = " + y +" x = " + x + " 방향 = " + dir + " 비용 = " + cost + "}";
        }
    }
}