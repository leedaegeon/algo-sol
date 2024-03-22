import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[1] = gems.length;
        Set<String> set = new HashSet<>();
        for(String gem: gems){
            set.add(gem);
        }
        
        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        
        for(int i=0; i<gems.length; i++){
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            
            while(map.size() == set.size()){
                
                if(answer[1] - answer[0] > i-left){
                    answer[0] = left+1;
                    answer[1] = i+1;
                }
                if(map.get(gems[left]) == 1){
                    map.remove(gems[left]);
                }else{
                    map.put(gems[left], map.get(gems[left])-1);
                }
                left++;
            }
            
        }
        
        // for(Map.Entry<String, Integer> e: map.entrySet()){
        //     System.out.println(e.getKey() + " " + e.getValue());
        // }
        
        return answer;
    }
}