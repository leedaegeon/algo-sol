import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();
        
        for(int i=0; i<number.length; i++){
            map.put(want[i], number[i]);
        }
        for(int i=0; i<10; i++){
            if(map.get(discount[i]) != null){
                map.put(discount[i], map.get(discount[i]) -1);
            }
            q.offer(discount[i]);
        }
        
        int cnt = 0;
        for(Map.Entry<String, Integer> e: map.entrySet()){
            // System.out.println(e.getKey() + " " + e.getValue());
            if(e.getValue()<=0){
                cnt++;
            }
        }
        if(cnt == want.length){
            answer++;
        }
        int next = 10;
        
        while(next < discount.length || !q.isEmpty()){
            String item = q.poll();
            cnt = 0;
            
            if(map.get(item) != null){
                map.put(item, map.get(item) + 1);
            }
            
            if(next < discount.length){
                String nextItem = discount[next++];
                if(map.get(nextItem) != null){
                    map.put(nextItem, map.get(nextItem)-1);
                }
                q.offer(nextItem);
            }
            
            for(Map.Entry<String, Integer> e: map.entrySet()){
            // System.out.println(e.getKey() + " " + e.getValue());
                if(e.getValue()<=0){
                    cnt++;
                }
            }
            if(cnt == want.length){
                answer++;
            }
        }
        
        return answer;
    }
}