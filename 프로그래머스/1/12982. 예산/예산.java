import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
//         예산
        int cnt = 0;
        Arrays.sort(d);
        int idx = 0;
        for(int i=0; i<d.length; i++){
            if(budget >= d[i]){
                budget -= d[i];
                answer++;
            }else{
                break;
            }
        }
        
       
        return answer;
    }
}