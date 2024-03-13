import java.util.*;
import java.io.*;
class Solution {
    public List<Integer> solution(int k, int[] score) {
        int[] answer = {};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<Math.min(k, score.length); i++){
            pq.offer(score[i]);
            min = Math.min(score[i], min);
            ans.add(min);
        }
        int i=k;
        while(i<score.length && !pq.isEmpty()){
            // System.out.println(score[i] + " " + pq.peek());
            if(!pq.isEmpty() && score[i] > pq.peek()){
                pq.poll();
                pq.offer(score[i]);
            }
            if(!pq.isEmpty()){
                ans.add(pq.peek());
            }
            
            i++;
        }
        
        return ans;
    }
}