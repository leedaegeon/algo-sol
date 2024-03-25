import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        if(n>=s){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }else{
            answer = new int[n];
            if(s%n == 0){
                for(int i=0; i<n; i++){
                    answer[i] = s/n;
                }
            }else{
                for(int i=0; i<n; i++){
                    answer[i] = s/n;
                }
                int idx = n-1;
                int cnt = 0;
                while(cnt<s%n){
                    answer[idx--]++;
                    cnt++;
                }

            }
            
        }
        
        return answer;
    }
}