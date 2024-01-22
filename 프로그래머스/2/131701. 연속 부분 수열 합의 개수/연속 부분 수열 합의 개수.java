import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> hs = new HashSet<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int last = 0;
        // for(int i=0; i<elements.length; i++){
        //     dq.offerLast(elements[i]);
        //     last += elements[i];
        //     hs.add(elements[i]);
        // }
        // hs.add(last);
        
        // int temp = 0;
//         for(int j=0; j<elements.length; j++){

//             for(int i=1; i<elements.length-1; i++){
//                 int sum = 0;
//                 for(int k=0; k<=i; k++){
//                     temp = dq.poll();
//                     sum+=temp;
//                     // System.out.print(temp + " ");
//                     dq.offerLast(temp);
                    
//                 }
//                 hs.add(sum);
//                 // System.out.println();
//                 // if(hs.add(sum)){
//                 //     System.out.print(sum + " ");
//                 // }
//             }
//             // System.out.println();
//         }
        
        for(int i=0; i<elements.length; i++){
            for(int j=0; j<elements.length; j++){
                int sum = 0;
                for(int k=0; k<=i; k++){
                    
                    if(j+k >= elements.length){
                        sum+=elements[(j+k)%elements.length];
                    }else{
                        sum += elements[j+k];
                    }
                }
                hs.add(sum);
                // if(hs.add(sum)){
                //     System.out.print(sum + " ");
                // }
            }
            // System.out.println();

        }
        answer = hs.size();
        
        return answer;
    }
}