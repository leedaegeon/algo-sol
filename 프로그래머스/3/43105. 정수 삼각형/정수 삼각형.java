import java.util.*;
class Solution {
    static int[] dy = {-1,-1};
    static int[] dx = {0, -1};
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int n = triangle.length;
        
        for(int i=1; i<n; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j == 0){
                    triangle[i][j] += triangle[i-1][j];    
                }else if(j == triangle[i].length-1){
                    triangle[i][j] += triangle[i-1][j-1];    
                }
                else{
                    triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                }
                answer = Math.max(triangle[i][j], answer);
            }
            
        }
        
        return answer;
    }
}