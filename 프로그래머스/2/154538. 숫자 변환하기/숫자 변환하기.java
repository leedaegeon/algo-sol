import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[y] = 0;
        
        for(int i = y; i>= x; i--){
            if(dp[i] == Integer.MAX_VALUE){
                continue;
            }
            if(i-n>=x){
                dp[i-n] = Math.min(dp[i] + 1, dp[i-n]);
            }
            if(i%2==0){
                dp[i/2] = Math.min(dp[i] + 1, dp[i/2]);
            }
            if(i%3 == 0){
                dp[i/3] = Math.min(dp[i] + 1, dp[i/3]);
            }
            
        }
        
        
        return dp[x]==Integer.MAX_VALUE?-1:dp[x];
    }
}