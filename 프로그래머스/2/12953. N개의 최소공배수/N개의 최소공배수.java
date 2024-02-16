import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] nextArr = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            nextArr[i] = arr[i];
        }
        int idx = -1;
        
        while(true){
            idx++;
            idx %= arr.length;
            int next = nextArr[idx];
            if(map.get(next) == null){
                map.put(next, 1);
                nextArr[idx] += arr[idx];
                
                continue;
            }
            map.put(next, map.get(next)+1);
            nextArr[idx] += arr[idx];

            if(map.get(next) == arr.length){
                answer = next;
                break;
            }
            
        }

        return answer;
    }
}