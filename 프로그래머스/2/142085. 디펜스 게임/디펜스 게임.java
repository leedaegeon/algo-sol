import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<enemy.length; i++){
            if(enemy[i] <= n){
                n -= enemy[i];
                pq.offer(enemy[i]);
                answer = i+1;
            }else if(k > 0){
                k--;
                n -= enemy[i];
                pq.offer(enemy[i]);
                n += pq.poll();                
                answer = i+1;
            }else{
                break;
            }
            // System.out.println(n + " " + k + " " + (i+1) + "라운드");
            
        }
        
        return answer;
    }
    
}