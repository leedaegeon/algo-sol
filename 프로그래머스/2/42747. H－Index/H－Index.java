import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int[] memo = new int[citations.length];
        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        Arrays.sort(citations);
        
        for(int citation: citations){
            map.put(citation, map.getOrDefault(citation, 0)+1);
        }
        
        for(int key: map.keySet()){
            for(int key2: map.keySet()){
                if(key <= key2){
                    map2.put(key, map2.getOrDefault(key,0) + map.get(key2));
                }
            }
        }
        for(int key: map2.keySet()){
            System.out.println(key + " " + map2.get(key));
            answer = Math.max(Math.min(key, map2.get(key)), answer);
        }
        
        return answer;
    }
}