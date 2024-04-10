import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        stack.addFirst(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            if(stack.isEmpty()){
                stack.addFirst(s.charAt(i));
            }else if(stack.peek() == s.charAt(i)){
                stack.removeFirst();
            }else{
                stack.addFirst(s.charAt(i));
            }
        }
        // for(char c: stack){
        //     System.out.print(c + " ");
        // }
        if(stack.size()==0){
            answer = 1;
        }else{
            answer = 0;
        }
        
        return answer;
    }
}