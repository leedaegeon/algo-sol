import java.util.*;
class Solution {
    public int[] solution(long begin, long end) {
    
        int[] answer = new int[(int)end - (int)begin+ 1];
        int start = 0;
        
        for(int i=start; i<answer.length; i++){
            int num = (int)begin+i;
            int maxDivisor = getMaxDivisor(num);
            answer[i] = maxDivisor;
            
        }
        return answer;
    }
    private static int getMaxDivisor(int num) {
        if (num == 1) {
            return 0;
        }

        int possibleDivisor = 1;
        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                possibleDivisor = i;
                if (num / i <= Math.pow(10,7)) {
                   return num/i;
                }
            }
        }
        return possibleDivisor;
   }
}