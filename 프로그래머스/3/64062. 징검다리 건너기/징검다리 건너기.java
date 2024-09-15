import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = 200_000_000;
        answer = binSearch(min, max, stones, k);
        return answer;
    }
    public int binSearch(int min, int max, int[] stones, int k){
        int answer = 0;
        while(min < max){
            int mid = min + (max - min)/2;
            if(jump(stones, mid, k)){
                answer = mid;
                min = mid+1;
            }else{
                max = mid;
            }
        }
        return answer;
    }
    
    public boolean jump(int[] stones, int mid, int k){
        boolean flag = true;
        int cnt = 0;
        for(int i=0; i<stones.length; i++){
            if(stones[i] - mid < 0){
                cnt++; 
            }else{
                cnt = 0;
            }
            if(cnt == k){
                flag = false;
                break;
            }
        }
        return flag;
    }
    
}