class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 2;
        for(int i=3; i<=n; i++){
            memo[i] = (memo[i-1]+memo[i-2])%1_000_000_007;
        }
        answer = memo[n];
        return answer;
    }
}