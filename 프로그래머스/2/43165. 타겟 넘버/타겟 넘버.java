class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {

        comb(0, target, numbers);
        return answer;
    }
    public void comb(int idx, int target, int[] numbers){
        if(idx == numbers.length){
            if(target == 0){
                answer++;
            }
            return;
        }
        comb(idx+1, target+numbers[idx], numbers);
        comb(idx+1, target-numbers[idx], numbers);
    }
}