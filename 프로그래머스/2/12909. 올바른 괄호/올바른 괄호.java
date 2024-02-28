import java.util.*;
class Solution {
    boolean solution(String s) {        
        Deque<Character> dq = new ArrayDeque<>();
        
        dq.addFirst(s.charAt(0));
        
        for(int i=1; i<s.length(); i++){
            if(!dq.isEmpty()&& dq.peekFirst() == '(' && s.charAt(i) == ')'){
                dq.removeFirst();
                continue;
            }
            dq.addFirst(s.charAt(i));
        }
        return dq.isEmpty()?true:false;
    }
}