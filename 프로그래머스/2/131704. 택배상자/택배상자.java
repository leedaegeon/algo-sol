import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Deque<Integer> subStack = new LinkedList<>();
        int idx = 0;
        for(int i=0; i<order.length; i++){
            subStack.addFirst(i+1);
            
            while(!subStack.isEmpty()){
                int val  = subStack.peekFirst();
                if(val == order[idx]){
                    subStack.removeFirst();
                    answer++;
                    idx++;
                }else{
                    break;

                }
            }

        }
        return answer;
    }
}