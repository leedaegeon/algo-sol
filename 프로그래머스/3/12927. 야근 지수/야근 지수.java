import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w: works){
            pq.offer(w);
        }

        while(!pq.isEmpty() && n>0 && pq.peek() != 0){
            int first = pq.poll();
            
            if(first >= pq.peek()){
                first--;
                n--;
            }
            pq.offer(first);
        }
        
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}