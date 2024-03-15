import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] dp = new int[n+1];
        Arrays.sort(money);
        dp[0] = 1;
        
        for(int i=0; i<money.length; i++){
            for(int j=money[i]; j<dp.length; j++){
                dp[j] += dp[j-money[i]];
            }
        }
        
        // System.out.println(Arrays.toString(dp));

        return dp[n];
    }
}