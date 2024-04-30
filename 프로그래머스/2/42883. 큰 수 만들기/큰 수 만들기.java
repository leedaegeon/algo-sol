import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Deque<Integer> dq = new ArrayDeque<>();
        int cnt = 0;
        for(int i=0; i<number.length(); i++){
            
            while(!dq.isEmpty() && dq.peekFirst() < number.charAt(i)-'0' && cnt < k)            {
                dq.removeFirst();     
                cnt++;
            }
            dq.addFirst(number.charAt(i)-'0');
        }
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty() && cnt < k){
            dq.removeFirst();
            cnt++;
        }
        while(!dq.isEmpty()){
            int num = dq.removeLast();
            sb.append(num);    
        }
        
        try{
            Long a = Long.parseLong(sb.toString());
            answer = Long.toString(a);
        }catch(NumberFormatException e){
            answer = sb.toString();
        }
        
        
        return answer;
    }
}