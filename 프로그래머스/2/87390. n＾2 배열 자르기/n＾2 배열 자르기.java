import java.util.*;
class Solution {
    public long[] solution(int n, long left, long right) {
        
        int[] dy = {0, 1, 1};
        int[] dx = {1, 1, 0};
        
        List<Long> ls = new LinkedList<>();
        for(long i=left; i<=right; i++){
            ls.add(Math.max(i/n, i%n)+1);
        }
        long[] answer = new long[ls.size()];
        for(int i=0; i<ls.size(); i++){
            answer[i] = ls.get(i);
        }
        return answer;
    }
    
}