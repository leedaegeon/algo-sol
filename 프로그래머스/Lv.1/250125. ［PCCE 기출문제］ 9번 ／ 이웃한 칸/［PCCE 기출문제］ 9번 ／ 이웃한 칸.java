import java.util.*;
class Solution {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        // System.out.println(board[h][w]);
        
        for(int i=0; i<4; i++){
            if(h+dy[i] <0 || h+dy[i] >=board.length || w+dx[i]<0 || w+dx[i]>=board[0].length){
                continue;
            }
            if(board[h][w].equals(board[h+dy[i]][w+dx[i]])){
                // System.out.println(h+dy[i] + " " + w+dx[i]);
                answer++;
            }
        }
        
        return answer;
    }
}