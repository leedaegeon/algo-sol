class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int[] dp = new int[right+1];
        for(int i=0; i<=right; i++){
            for(int j=0; j<= right; j++){
                if(i*j>=left && i*j<=right){
                    dp[i*j]++;
                    
                }
            }
        }
        for(int i=left; i<=right; i++){
            if(dp[i]%2 == 0){
                answer += i;
            }else{
                answer -= i;
            }
        }
        return answer;
    }
}