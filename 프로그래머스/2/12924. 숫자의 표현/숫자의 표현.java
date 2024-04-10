class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] nums = new int[n+1];
        for(int i=0; i<n+1; i++){
            nums[i] = i;
        }
        int sum = 0;
        int left = 1;
        int right = 1;
        while(right < n+1 || left < n+1){
            if(sum<n){
                sum += nums[right++];
            }else if(sum>=n){
                if(sum==n){
                    answer++;
                }
                sum -= nums[left++];
            }
            // System.out.println(sum + " " + left + " " + right);
        }
        return answer;
    }
}