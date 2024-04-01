import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        row_begin -= 1;
        row_end -= 1;
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col-1] == o2[col-1]){
                return o2[0] - o1[0];
            }else{
                return o1[col-1] - o2[col-1];
            }
        });
        for(int i=row_begin; i<=row_end; i++){
            int x = 0;
            for(int j=0; j<data[i].length; j++){
                x += data[i][j]%(i+1);
            }
            answer ^= x;
        }
        
        return answer;
    }
}