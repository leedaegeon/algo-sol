import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        int[] nextArr = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            nextArr[i] = arr[i];
        }
        int idx = 0;
        
        while(true){
            
            int next = nextArr[idx];
            if(map.get(next) == null){
                map.put(next, 1);
                nextArr[idx] += arr[idx];
                idx++;
                idx %= arr.length;
                continue;
            }
            map.put(next, map.get(next)+1);
            nextArr[idx] += arr[idx];
            // for(Map.Entry m: map.entrySet()){
            //     System.out.println(m.getKey() + " "+ m.getValue());
            // }
            // System.out.println("====================");
            if(map.get(next) == arr.length){
                answer = next;
                break;
            }
            
            idx++;
            idx %= arr.length;
            
        }

        return answer;
    }
}