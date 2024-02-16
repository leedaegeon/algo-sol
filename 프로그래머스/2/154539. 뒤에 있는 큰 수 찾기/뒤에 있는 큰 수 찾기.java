import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=numbers.length-1; i>=0; i--){
            
            while(!stack.isEmpty() && stack.peekFirst() <= numbers[i]){
                stack.removeFirst();
            }
            if(!stack.isEmpty()){
                answer[i] = stack.peekFirst();
            }
            
            stack.addFirst(numbers[i]);
            
        }        
        return answer;
    }
}