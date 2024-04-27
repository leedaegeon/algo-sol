class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++){
            long k = 1;
            while(true){
                long findZero = numbers[i] | k;
                if(findZero > numbers[i]){
                    k = k>>1;
                    answer[i] = findZero^k;
                    break;
                }else{
                    k = k<<1;
                }
            }
        }
        return answer;
    }
}