import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
	    
        int[][] dp = new int[sticker.length-1][2];
        for(int i=0; i<dp.length; i++){
//             첫 번째 원소 선택
            dp[i][0] = sticker[i];
        }
        for(int i=0; i<dp.length; i++){
//             두 번째 원소 선택
            dp[i][1] = sticker[i+1];
        }
        if(dp.length <= 1){
            return sticker[0];
        }
        dp[1][0] = Math.max(dp[0][0], dp[1][0]);
        dp[1][1] = Math.max(dp[0][1], dp[1][1]);
        
        for(int i=2; i<dp.length; i++){
            
            dp[i][0] = Math.max(dp[i-2][0] + dp[i][0], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-2][1] + dp[i][1], dp[i-1][1]);
        }
        // for(int i=0; i<dp.length; i++){
        //     System.out.print(dp[i][0] + " ");
        // }
        // System.out.println();
        // for(int i=0; i<dp.length; i++){
        //     System.out.print(dp[i][1] + " ");
        // }
        answer = Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
        return answer;
    }
}