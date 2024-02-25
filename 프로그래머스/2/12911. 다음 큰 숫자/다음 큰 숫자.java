import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        int k = n + 1;
        while(n > 0){
            if(n%2 == 1){
                cnt++;
            }
            n /= 2;
        }
        
        while(true){
            int temp = k;
            int tempCnt = 0;
            while(temp > 0){
                if(temp%2 == 1){
                    tempCnt++;
                }
                temp /= 2;
            }
            if(tempCnt == cnt){
                answer = k;
                break;
            }
            k++;
        }
        
      
        return answer;
    }
}