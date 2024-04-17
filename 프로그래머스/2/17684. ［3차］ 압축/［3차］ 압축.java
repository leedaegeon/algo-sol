import java.util.*;
class Solution {
    public List<Integer> solution(String msg) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        char c = 65;
        for(int i=1; i<27; i++){
            map.put(c+"", i);
            c++;
        }
        // for(String key: map.keySet()){
        //     System.out.println(key + " " + map.get(key));
        // }
        List<Integer> ans = new LinkedList<>();
        int lastIdx = 26;
        for(int i=0; i<msg.length();){
            int addIdx=0;
            for(int j=i+1; j<=msg.length(); j++){
                String s = msg.substring(i,j);                
                if(map.get(s) == null){
                    ans.add(map.get(msg.substring(i,j-1)));
                    map.put(s, ++lastIdx);
                    break;
                }else if(j==msg.length()){
                    ans.add(map.get(s));
                }
                addIdx++;
            }
            i += addIdx;
        }
        return ans;
    }
}