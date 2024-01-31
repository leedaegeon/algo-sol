import java.util.*;
class Solution {
    static Deque<Character> stack;
    public int solution(String s) {
        int answer = 0;
//         1. 회전 = 문자열 길이만큼
//         2. origin q를 남기고
//         3. Deque에 넣고 스택으로 사용
//         4. flag 배열 사용
//         *** addFirst, pollFirst써서 peek() 그대로 사용할 수 있는 환경 만들자 ***
        Queue<Character> q = new ArrayDeque<>();
        char[] start = {'[', '{', '('};
        char[] end = {']', '}', ')'};
        
        
        for(int i=0; i < s.length(); i++){
            q.offer(s.charAt(i));
        }
        
        for(int i=0; i<s.length(); i++){
            Queue<Character> q2 = new ArrayDeque<>(q);
            stack = new LinkedList<>();
            int size = q2.size();
            
            for(int j=0; j< size; j++){
                boolean flag = false;
                char c = q2.poll();
                
                if(stack.isEmpty()){
                    stack.addFirst(c);
                    continue;
                }
  
                for(int k=0; k<3; k++){
                    if(stack.peek() == start[k] && c == end[k]){
                        char c2 = stack.pollFirst();
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    stack.addFirst(c);
                }

            }
            
            if(stack.isEmpty()){
                answer++;
            }            
            q.offer(q.poll());
        }        
        return answer;
    }
    
    
    
}