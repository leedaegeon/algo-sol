import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
//         1. 각 progresses별 며칠걸리는지 계산
//         2. 현재 값보다 작은 것들 카운팅후 answer배열에 할당
        int[] time = new int[progresses.length];
        
        for(int i=0; i<progresses.length; i++){
            int total = 100 - progresses[i];
            
            if(total > speeds[i] && total%speeds[i] != 0){
                total /= speeds[i];            
                total += 1;
            }else if(total <= speeds[i]){
                total = 1;
            }else{
                total /= speeds[i];            
            }
            time[i] = total;
        }
        int localMax = time[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        int date = 0;
        map.put(date, 1);
        // for(int i=0; i<time.length; i++){
        //     System.out.println(time[i]);
        // }
        // System.out.println("=========================");
        
        for(int i=1; i<time.length; i++){
            if(localMax >= time[i]){
                map.put(date, map.getOrDefault(date, 0) + 1);
            }else{
                date++;
                localMax = time[i];
                map.put(date, 1);
            }

        }
        answer = new int[map.size()];
        
        // for(Map.Entry<Integer, Integer> m: map.entrySet()){
        //     System.out.println(m.getKey() + " " + m.getValue());
        // }
        for(int i=0; i<map.size(); i++){
            answer[i] = map.get(i);
        }
        return answer;
    }
}