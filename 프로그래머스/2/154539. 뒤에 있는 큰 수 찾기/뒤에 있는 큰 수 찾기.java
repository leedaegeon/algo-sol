import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=numbers.length-1; i>=0; i--){
            if(stack.isEmpty()){
                stack.addFirst(numbers[i]);
                continue;
            }
            // for(Integer k: stack){
            //     System.out.print(k + " ");
            // }
            // System.out.println("\n " + numbers[i]);
            // System.out.println("-------------------------");
            while(!stack.isEmpty()){
                if(stack.peek() > numbers[i]){
                    answer[i] = stack.peekFirst();
                    break;
                }else{
                    stack.removeFirst();
                }
            }
            stack.addFirst(numbers[i]);
            
        }        
        return answer;
    }
}