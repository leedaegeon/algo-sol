import java.util.*;
class Solution {
    static int di[] = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int dj[] = {-1, 0, 1, 1, 1, 0, -1, -1, -1};
    static int answer = 0;
    public int solution(int[][] board) {
        int n = board.length;
        for(int i=0; i<n*n; i++){
            if(board[i/n][i%n] == 1){
                board = dfs(i/n, i%n, board, n);
            }
        }
        // for(int i=0; i<board.length; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }  
        return (n*n)-answer;
    }
    public int[][] dfs(int nexty, int nextx, int[][] board, int n){
        if(nexty < 0 || nexty >= n || nextx < 0 || nextx >= n){
            return board;
        }
        if(board[nexty][nextx] == 2){
            return board;
        }
        answer++;
//         8방 탐색할 권한은 폭탄좌표에만 부여
        if(board[nexty][nextx] == 1){
            board[nexty][nextx] = 2;
            for(int i=0; i<8; i++){
                board = dfs(nexty + di[i], nextx + dj[i], board, n);
            }
        }else if(board[nexty][nextx] == 0){
            board[nexty][nextx] = 2;
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