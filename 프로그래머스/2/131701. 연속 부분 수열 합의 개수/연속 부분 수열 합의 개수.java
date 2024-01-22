import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> hs = new HashSet<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int last = 0;
        for(int i=0; i<elements.length; i++){
            dq.offerLast(elements[i]);
            last += elements[i];
            hs.add(elements[i]);
        }
        hs.add(last);
        
        int temp = 0;
//         i개씩 뽑아보는 것을 j번
        for(int i=2; i<elements.length; i++){
            for(int j=0; j<elements.length; j++){
                int sum = 0;
                for(int k=0; k<i; k++){
                    temp = dq.pollFirst();
                    System.out.print(temp + " ");
                    sum += temp;
                    dq.offerLast(temp);
                }
                hs.add(sum);
                // if(hs.add(sum)){
                //     System.out.print(sum + " ");
                // }
                System.out.println();
                
            }
            // System.out.println();
        }
        answer = hs.size();
        
        return answer;
    }
}