import java.util.*;
class Solution {
    static int[] di = {0, 1};
    static int[] dj = {1, 0};
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] field = new int[n][m];
        
        for(int[] p: puddles){
            field[p[1]-1][p[0]-1] = -1;
        }
        field[0][0] = 1;
        for(int y=0; y<n; y++){
            for(int x=0; x<m; x++){
                // if(y==0 && x==0){
                //     continue;
                // }
                // System.out.println(y + " " + x);
                if(field[y][x] == -1){
                    continue;
                }
                for(int d=0; d<2; d++){
                    
                    int nexty = y + di[d];
                    int nextx = x  + dj[d];
                    if(nexty >= n || nextx >= m || field[nexty][nextx] == -1){
                        continue;
                    }
                    field[nexty][nextx] += (field[y][x]%1_000_000_007);
                }
            }
        }
//         for(int y=0; y<n; y++){
//             for(int x=0; x<m; x++){
//                 System.out.print(field[y][x] + " ");
                
//             }
//             System.out.println();
//         }
        
        return field[n-1][m-1]%1_000_000_007;
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