import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        int[] posMulSequence = getMulSequence(1, sequence);
        int[] negMulSequence = getMulSequence(0, sequence);
        long pos = getSubSequenceSum(posMulSequence);
        long neg = getSubSequenceSum(negMulSequence);
        long answer = Math.max(pos, neg);

        
        return answer;
    }

    public long getSubSequenceSum(int[] sequence){
        long calcSum = sequence[0];  // 현재까지의 최대 부분합
        long currentSum = sequence[0];  // 현재까지의 부분합

        for(int i = 1; i < sequence.length; i++){
            currentSum = Math.max(sequence[i], currentSum + sequence[i]);  // 부분합을 갱신
            calcSum = Math.max(calcSum, currentSum);  // 최대 부분합을 갱신
        }

        // System.out.println(Arrays.toString(cumSum));
        return calcSum;
    }
//     sign이 짝수면 펄스 수열 1부터 시작
    public int[] getMulSequence(int sign, int[] sequence){
        int [] newSequence = new int[sequence.length];
        for(int i=0; i<sequence.length; i++){
            if((i&1) == sign){
                newSequence[i] = sequence[i] * -1;
            }else{
                newSequence[i] = sequence[i];
            }
        }

        return newSequence;
    }
}