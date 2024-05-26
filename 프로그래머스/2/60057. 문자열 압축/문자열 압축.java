import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 1001;
        // Part p2 = find(s, 0, 1, 1, s.substring(0,1));
        // System.out.println(p.nextIdx);
        int totalLen = (s.length())/2+1;
        
        for(int len = 1; len < totalLen; len++){
            // System.out.println("=========================");
            
            String ans = find(s,len);
            // System.out.println("길이: " + len +" 압축: " + ans);
            answer = Math.min(answer, ans.length());
            
            // System.out.println("=========================");
            
        }
        if(answer == 1001){
            answer = 1;
        }
        
        return answer;
    }
    public String find(String s, int len){
        
        int cnt = 1;
        String sub = s.substring(0, len);
        StringBuilder sb = new StringBuilder();
        int i;
        for(i = len; i<= s.length()-len; i+= len){
            String cmp;
            cmp = s.substring(i,i+len);
            // System.out.println(cmp);
            if(sub.equals(cmp) ){
                cnt++;
            }else{
                if(cnt != 1){
                    sb.append(cnt);
                    sb.append(sub);
                }else{
                    sb.append(sub);
                }
                cnt = 1;
                sub = cmp;
            }
            
        }
        
        if(cnt != 1){
            sb.append(cnt);
            sb.append(sub);
            if(i<s.length()){
                sb.append(s.substring(i));
            }
        }else{
            sb.append(sub);
            sb.append(s.substring(i));
            // System.out.println("길이-" + len + " " + i);
        }

        // System.out.println(cnt);
        return sb.toString();
        
    }
    
}