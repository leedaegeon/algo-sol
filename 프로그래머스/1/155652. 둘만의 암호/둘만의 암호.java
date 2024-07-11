import java.util.*;
class Solution {
    
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();
        for(int i=0; i<skip.length(); i++){
            skipSet.add(skip.charAt(i));
        }
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int cnt = 0;
            int idx = 1;
            while(true){
                int nextCharInt = ((int)c +idx);
                if(nextCharInt > 'z'){
                    c = 'a';
                    idx = 0;
                    continue;
                }
                if(skipSet.contains((char)nextCharInt)){
                    idx++;
                }else{
                    cnt++;
                    idx++;
                }
                if(cnt == index){
                    sb.append((char)nextCharInt);
                    break;
                }
            }
            
        }
        
        return sb.toString();
    }
}