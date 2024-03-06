import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();
        int total = 0;
        for(int a: number){
            total += a;
        }
        for(int i=0; i<number.length; i++){
            map.put(want[i], number[i]);
        }
        for(int i=0; i<10; i++){
            if(map.get(discount[i]) != null){
                map.put(discount[i], map.get(discount[i]) -1);
                if(map.get(discount[i]) >= 0){
                    total--;
                }
            }
            q.offer(discount[i]);
        }
        
        if(total == 0){
            answer++;
        }
        int next = 10;
        
        while(next < discount.length || !q.isEmpty()){
            String item = q.poll();
            
            if(map.get(item) != null){
                map.put(item, map.get(item) + 1);
                if(map.get(item) > 0){
                    total++;
                }
            }
            if(total == 0){
                answer++;
            }
            if(next < discount.length){
                String nextItem = discount[next++];
                if(map.get(nextItem) != null){
                    map.put(nextItem, map.get(nextItem)-1);
                    if(map.get(nextItem) >= 0){
                        total--;
                    }
                }
                q.offer(nextItem);
            }
            if(total == 0){
                answer++;
            }
            
        }
        
        return answer;
    }
}