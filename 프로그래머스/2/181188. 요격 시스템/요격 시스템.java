import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (o1, o2) -> {
                return o1[1] - o2[1];            
        });
        // for(int[] arr: targets){
        //     System.out.println(arr[0] + " " + arr[1]); 
        // }
        int spot = targets[0][1];
        for(int i=1; i<targets.length; i++){
//             함께 요격 불가
            if(spot <= targets[i][0]){
                answer++;
                spot = targets[i][1];
                
                // System.out.println(spot);
                System.out.println(targets[i][0] +" " + targets[i][1]);
            }else{
                // spot = Math.min(spot, targets[i][1]);
                // System.out.println(spot);
                
            }
        }
        
        return answer;
    }
}