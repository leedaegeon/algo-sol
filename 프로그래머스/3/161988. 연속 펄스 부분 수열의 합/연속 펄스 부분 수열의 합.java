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
        long[] cumSum = new long[sequence.length];
        cumSum[0] = sequence[0];
        long calcSum = cumSum[0];
        long minSum = 0;
        
        for(int i=1; i<sequence.length; i++){
            
            cumSum[i] = cumSum[i-1] + sequence[i];
            
            // System.out.println(cumSum[i] + " - " + minSum +" "+ (cumSum[i] - minSum) +" vs " + calcSum);
            
            calcSum = Math.max(cumSum[i] - minSum, calcSum);
            minSum = Math.min(minSum, cumSum[i]);
            
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