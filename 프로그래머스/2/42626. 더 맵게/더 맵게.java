import java.util.*;
class Solution {
    public int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s: scoville){
            pq.offer(s);
        }
        // System.out.println(pq.size());
        while(!pq.isEmpty()){
            if(pq.size()>=2){
                int first = pq.poll();
                int second = pq.poll();
                int newOne = first + (second*2);
                if(first >= k){
                    break;
                }
                // System.out.println(newOne);

                pq.offer(newOne);

                answer++;
            }else if(pq.size() == 1 && pq.poll() < k){
                answer = -1;
                break;
            }
        }
        return answer;
    }
}