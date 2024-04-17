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
        int lastIdx = 27;
        int lastI = 0;
        for(int i=0; i<msg.length();){
            int k=0;
            System.out.println(i);
            for(int j=i+1; j<=msg.length(); j++){
                String s = msg.substring(i,j);
                    // System.out.println(s);
                
                if(map.get(s) == null){
                    ans.add(map.get(msg.substring(i,j-1)));
                    map.put(s, lastIdx++);
                    break;
                }else if(j==msg.length()){
                    ans.add(map.get(s));
                }
                k++;
            }
            i += k;

            
        }
        // System.out.println(ans);
        return ans;
    }
}