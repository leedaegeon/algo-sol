import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] p = priorities;

        Integer[] sorted = new Integer[priorities.length];
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<priorities.length; i++){
            sorted[i] = p[i];    
            q.offer(p[i]);
        }
        Arrays.sort(sorted, (o1, o2) ->{
            return o2-o1;
        });
        int idx = 0;
        while(!q.isEmpty()){
            int current = q.poll();
//             만약 우선순위가 128이상일 경우 ==이 아닌 equals를 사용해야함
            if(!sorted[idx].equals(current)){
                q.offer(current);                
                if(location == 0){
                location = q.size()-1;
                }else{
                    location--;
                }
                continue;
            }
            answer++;
            if(location == 0){
                break;
            }
            idx++;
            location--;
            // System.out.println(current + " " + location);
            
        }
            
        
        return answer;
    }
}