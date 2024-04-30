import java.util.*;
class Solution {
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    public List<Integer> solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        int[][] field = new int[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                field[i][j] = (i)*columns + j+1;
            }
        }
        List<Integer> ans = new LinkedList<>();
        int idx = 0;
        while(idx < queries.length){
            int minRow = queries[idx][0]-1;
            int maxRow = queries[idx][2]-1;
            int minCol = queries[idx][1]-1;
            int maxCol = queries[idx][3]-1;
            int nowy = minRow;
            int nowx = minCol;
            int nowVal = field[nowy][nowx];
                        
            int dir = 0;
            int minVal = nowVal;
            
            while(dir < 4){
                
                int nexty = nowy + di[dir];
                int nextx = nowx + dj[dir];
                
                if(nexty < minRow || nexty > maxRow || nextx < minCol || nextx > maxCol){
                    dir++;
                    continue;
                }
                
                int tempVal = field[nexty][nextx];
                minVal = Math.min(minVal, tempVal);
                field[nexty][nextx] = nowVal;
                nowVal = tempVal;
                nowy = nexty;
                nowx = nextx;
            }
            ans.add(minVal);
            idx++;
        }
        // for(int i=1; i<field.length; i++){
        //     for(int j=1; j<field[i].length; j++){
        //         System.out.print(field[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return ans;
    }
}