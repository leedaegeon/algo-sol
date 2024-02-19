import java.util.*;
class Solution {
    static int di[] = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int dj[] = {-1, 0, 1, 1, 1, 0, -1, -1, -1};
    static int answer = 0;
    public int solution(int[][] board) {
        int n = board.length;
        for(int i=0; i<n*n; i++){
            if(board[i/n][i%n] == 1){
                board = bfs(i/n, i%n, board, n);
            }
        }
        
        
        
        return (n*n)-answer;
    }
    public int[][] bfs(int starty, int startx, int[][] board, int n){
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(starty, startx));
        
        while(!q.isEmpty()){
            Point now = q.poll();
            int y = now.y;
            int x = now.x;
            if(board[y][x] == 2){
                continue;
            }
            board[y][x] = 2;
            answer++;

            for(int i=0; i<8; i++){
                int nexty = y+di[i];
                int nextx = x+dj[i];
                if(nexty < 0 || nexty >= n || nextx < 0 || nextx >= n){
                    continue;
                }
                if(board[nexty][nextx] == 1){
                    q.offer(new Point(nexty,nextx));
                }else if(board[nexty][nextx] == 0){
                    answer++;
                    board[nexty][nextx] = 2;
                }

            }          
            
        }
        return board;
    }
    class Point{
        int y;
        int x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}