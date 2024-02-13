import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] tang = new int[10_000_001];
        for(int i=0; i<tangerine.length; i++){
            tang[tangerine[i]] += 1;
        }
        Arrays.sort(tang);

        for(int i=tang.length-1; i>=0; i--){
            if(tang[i] == 0){
                continue;
            }
            
            if(k >= tang[i]){
                // System.out.println(tang[i]);
                k -= tang[i];
                answer++;
            }else{
                System.out.println(tang[i]);
                answer++;
                break;
            }
            if(k==0){
                break;
            }
        }
        return answer;
    }
}