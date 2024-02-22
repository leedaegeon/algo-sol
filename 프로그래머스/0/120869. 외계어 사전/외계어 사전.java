import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(String s: spell){
            map.put(s.charAt(0), 0);
        }
        for(int i=0; i<dic.length; i++){
            for(int j=0; j<dic[i].length(); j++){
                if(map.get(dic[i].charAt(j)) != null){
                    map.put(dic[i].charAt(j), map.get(dic[i].charAt(j)) + 1);
                }
            }
            int check = 0;
            for(Map.Entry<Character, Integer> m: map.entrySet()){
                if(m.getValue() == 1){
                    check++;
                }
            }
            // System.out.print(sum);
            if(check == spell.length){
                return 1;
            }
            for(String s: spell){
                map.put(s.charAt(0), 0);
            }
        }
        
        return answer;
    }
}