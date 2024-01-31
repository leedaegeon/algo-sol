import java.util.*;
class Solution {
    static Deque<Character> stack;
    public int solution(String s) {
        int answer = 0;
//         1. 회전 = 문자열 길이만큼
//         2. origin q를 남기고
//         3. Deque에 넣고 스택으로 사용
//         4. flag 배열 사용
        
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
                // System.out.print(c + " ");
                
                if(stack.isEmpty()){
                    stack.addLast(c);
                    continue;
                }
                // for(char c2: stack){
                //     System.out.print(c2 + " ");
                // }
                // System.out.println(stack.peek() + " " + c);
                for(int k=0; k<3; k++){
                    if(stack.peekLast() == start[k] && c == end[k]){
                        char c2 = stack.pollLast();
                        // System.out.println("poll "+c2 + " " + c);        
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    // System.out.println("add " + c + " ");
                    stack.addLast(c);
                }

            }
            
            if(stack.isEmpty()){
                answer++;
            }            
            // System.out.println(answer);
            q.offer(q.poll());
        }        
        return answer;
    }
    public boolean check(char[] start, char[] end, char c){
        for(int k=0; k<3; k++){
            if(c == end[k] && stack.peek() == start[k]){
                char c2 = stack.pollLast();
                // System.out.print(c2 + " " + c);
                return true;
            }
        }
        
        return false;
    }
    
    
}