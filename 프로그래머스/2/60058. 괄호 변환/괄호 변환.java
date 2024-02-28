import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
       
//         1. 이미 올바른 괄호 문자열인지 판단
//         2. 문제 알고리즘 적용
        if(check(p) || p.length() == 0){
            return p;
        }
        String w = divide(p);
        
        // System.out.println(w);

        answer = w;
        return answer;
    }

    
    public String divide(String p){
        if(p.length() == 0){
            return "";
        }
        int leftCnt = 0;
        int rightCnt = 0;
        int idx = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                leftCnt++;
            }else{
                rightCnt++;
            }
            if(leftCnt == rightCnt){
                idx = i;
                break;
            }
        }
        String u = "";
        String v = "";
        StringBuilder sb = new StringBuilder();


        if(idx == p.length()-1){
            u = p;
            v = "";
        }else{
            
            u = p.substring(0, idx+1);
            v = divide(p.substring(idx+1, p.length()));
        }
        
        if(check(u)){
            v = divide(v);
        }else{
            sb.append("(");
            sb.append(v);
            sb.append(")");
            for(int i=1; i<u.length()-1; i++){
                if(u.charAt(i) =='('){
                    sb.append(")");
                }else{
                    sb.append("(");
                }
            }
            
            // System.out.print(divide(p.substring(idx+1, p.length())));
            return sb.toString();
        }

        
        return u+v;

    }
    public boolean check(String p){
        if(p.length() == 0){
            return false;
        }
        
        Deque<Character> dq = new ArrayDeque<>();
        dq.addFirst(p.charAt(0));
        
        for(int i=1; i<p.length(); i++){

            if(!dq.isEmpty() && dq.peekFirst() == '(' && p.charAt(i) == ')'){
                dq.removeFirst();
                continue;
            }
            dq.addFirst(p.charAt(i));
        }
        
        return dq.isEmpty()?true:false;
    }
}