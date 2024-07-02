class Solution {

    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = comb(0, target, numbers);
        return answer;
    }
    public int comb(int idx, int target, int[] numbers){
        if(idx == numbers.length){
            if(target == 0){
                return 1; 

            }else{
                return 0;
            }
        }
        
        int a = comb(idx+1, target+numbers[idx], numbers);
        int b = comb(idx+1, target-numbers[idx], numbers);
        return a+b;
    }
}