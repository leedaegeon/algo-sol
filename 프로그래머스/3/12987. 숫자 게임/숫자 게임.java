import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> pqA = new PriorityQueue<>(Collections.reverseOrder());
        for(int e: A){
            pqA.offer(e);
        }
        PriorityQueue<Integer> pqB = new PriorityQueue<>(Collections.reverseOrder());
        for(int e: B){
            pqB.offer(e);
        }
        
        
        while(!pqA.isEmpty()){
            int a = pqA.poll();
            int b = 0;
            if(a < pqB.peek()){
                answer++;
                pqB.poll();
                // b = pqB.poll();
            }
            // System.out.println(a + " " + b);
        }
        return answer;
    }
}