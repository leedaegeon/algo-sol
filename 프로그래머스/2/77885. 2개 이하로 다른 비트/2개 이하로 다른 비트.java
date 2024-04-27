class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++){
            long k = 1;
            while(true){
                long findLowestZeroBit = numbers[i] | k;
                if(findLowestZeroBit > numbers[i]){
                    // 최하위 0비트의 이전비트는 1이므로 0으로 변환하기 위해 
                    // 기존 k를 오른쪽 1비트 쉬프트
                    // 후 XOR로 1을 0으로 토글
                    k >>= 1;
                    answer[i] = findLowestZeroBit^k;
                    break;
                }else{
                    k <<= 1;
                }
            }
        }
        return answer;
    }
}