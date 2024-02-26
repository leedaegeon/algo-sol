import java.util.*;
class Solution
{
    public Integer solution(int []A, int []B)
    {
        Integer answer = 0;
        PriorityQueue<Integer> incQ = new PriorityQueue<>();
        PriorityQueue<Integer> decQ = new PriorityQueue<>((o1, o2) -> {return o2-o1;});
        
        for(int i=0; i<A.length; i++){
            incQ.offer(A[i]);
            decQ.offer(B[i]);
        }
        while(!incQ.isEmpty() && !decQ.isEmpty()){
            int left = incQ.poll();
            int right = decQ.poll();
            int mul = left*right;
            answer += mul;
        }
        

        return answer;
    }
}