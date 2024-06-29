import java.util.*;
class Solution {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> pqA = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqB = new PriorityQueue<>(Collections.reverseOrder());
        for(int a: A){
            pqA.offer(a);
        }
        for(int b: B){
            pqB.offer(b);
        }
        
        while(!pqB.isEmpty() ){
            int b = pqB.poll();
            while(!pqA.isEmpty() && b <= pqA.peek()){
                pqA.poll();
            }
            if(!pqA.isEmpty() && b > pqA.peek()){
                answer++;
                pqA.poll();
            }
        }
        
        return answer;
    }
    
}