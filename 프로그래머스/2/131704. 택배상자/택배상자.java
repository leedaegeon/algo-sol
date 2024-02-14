import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> mainQ = new LinkedList<>();
        Deque<Integer> subStack = new LinkedList<>();
        for(int i=1; i<=order.length; i++){
            mainQ.add(i);
        }
        for(int i=0; i<order.length; i++){
            // System.out.println(order[i] + " " + answer);
            
            if(!mainQ.isEmpty() && order[i] == mainQ.peek()){

                mainQ.poll();
                answer++;
                continue;
            }
            if(!subStack.isEmpty() && order[i] == subStack.peekFirst()){
                subStack.removeFirst();
                answer++;
                continue;
            }
            
            while(!mainQ.isEmpty()){
                int val = mainQ.poll();
                if(order[i] > val){
                    subStack.addFirst(val);    
                }else if(order[i] == val){
                    answer++;
                    break;
                }else{
                    return answer;
                }
                
            }
            
            
            // for(int a: mainQ){
            //     System.out.print(a + " ");
            // }
            // System.out.println("\n========================");
            // for(int a: subStack){
            //     System.out.print(a + " ");
            // }           
            // System.out.println("\n--------------------------");

        }
        return answer;
    }
}