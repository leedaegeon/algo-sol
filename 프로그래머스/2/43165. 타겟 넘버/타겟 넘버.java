class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        comb(0, 0, target, numbers);
        return answer;
    }
    public void comb(int idx, int sum, int target, int[] numbers){
        
        if(sum == target && idx == numbers.length){
            answer++;
            return;
        }
        
        if(idx == numbers.length){
            return;
        }
        comb(idx+1, sum + numbers[idx], target, numbers);
        comb(idx+1, sum - numbers[idx], target, numbers);
        
        
    }
}