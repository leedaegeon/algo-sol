import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sum = 0l;
        Queue<Integer> q1 = new ArrayDeque<>();
        long q1Val = 0l;
        
        Queue<Integer> q2 = new ArrayDeque<>();
        long q2Val = 0l;
        
        Set<Integer> hs = new HashSet<>();
        
        
        for(int i=0; i<queue1.length; i++){
            q1.offer(queue1[i]);
            sum += queue1[i];
            q1Val += queue1[i];
        }
        for(int j=0; j<queue2.length; j++){
            q2.offer(queue2[j]);
            sum += queue2[j];
            q2Val += queue2[j];
        }
        
        sum /= 2;
        int cnt = 0;
        while(q1Val != q2Val){
            int temp = 0;
            if(q1Val > q2Val){
                if(!q1.isEmpty()){
                    temp = q1.poll();
                    // System.out.print(temp + " ");
                    q1Val -= temp;
                    q2.offer(temp);
                    q2Val += temp;
                    answer++;
                    
                }
            }
            else if(q1Val < q2Val){
                if(!q2.isEmpty()){
                    temp = q2.poll();
                    // System.out.print(temp + " ");
                    q2Val -= temp;
                    q1.offer(temp);
                    q1Val += temp;
                    answer++;
                }
            }
            if(!hs.add(temp)){
                cnt++;
            }else{
                cnt = 0;
            }
            if(cnt == q1.size()*2){
                return -1;
            }
        }
        
        
        
        
        return answer;
    }
}