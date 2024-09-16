import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long minTime = 0;
        long maxTime = Long.MAX_VALUE;
        answer = test(n, times, minTime, maxTime);

        return answer;
    }
    public long test(int n, int[] times, long minTime, long maxTime){
        while(minTime < maxTime){
            
            long midTime = minTime + (maxTime - minTime)/2;
            
            long peopleCnt = getPeopleCnt(n, times, midTime);
            if(peopleCnt >= n){
                maxTime = midTime;
            }else{
                minTime = midTime + 1;
                
            }
            // System.out.println(peopleCnt + " " + minTime + " " + maxTime);
        }
        return minTime;
    }
    public long getPeopleCnt(int n, int[] times, long midTime){
        long peopleCnt = 0;
        for(int i=0; i<times.length; i++){
            try{
                // peopleCnt += midTime/times[i];
                peopleCnt = Math.addExact(midTime/times[i], peopleCnt);
            }catch(ArithmeticException e){
                return n;
            }
        }
        return peopleCnt;
    }
}