import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        boolean[] visited = new boolean[truck_weights.length];
        int[] delay = new int[truck_weights.length];
        Arrays.fill(delay, bridge_length);
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        if(weight < truck_weights[0]){
            return answer;
        }
        
        q.offer(0);
        weight -= truck_weights[0];
        bridge_length--;
        visited[0] = true;
        answer++;
        int j=1;
        while(!q.isEmpty()){
         
            
            for(int idx: q){
                delay[idx]--;
            }
            // System.out.print(answer + ": ");
            // for(int idx: q){
            //     System.out.print(delay[idx] + " ");
            // }
            // System.out.println();
            int now = q.peek();

            if(delay[q.peek()] == 0){
                now = q.poll();
                weight += truck_weights[now];
                bridge_length++;
            }
            answer++;
            if(j >= truck_weights.length){
                continue;
            }
            if((weight >= truck_weights[j] && bridge_length > 0)&&!visited[j]){
                weight -= truck_weights[j];
                bridge_length--;
                q.offer(j);
                visited[j] = true;
                j++;
                
            }            
        
            
        }
            
        return answer;
    }
}