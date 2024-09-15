import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<stones.length; i++){
            min = Math.min(min, stones[i]);
            max = Math.max(max, stones[i]);
        }
        if(min == max){
            return min;
        }

        answer = binSearch(min, max, stones, k);
        
        return answer;
    }
    public int binSearch(int min, int max, int[] stones, int k){
        boolean flag = true;
        int answer = 0;
        while(min < max){
            int mid = min + (max - min)/2;
            
            flag = jump(stones, mid, k);
            
            if(flag){
                answer = Math.max(answer, mid);
            }
            if(flag){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        // System.out.println(flag + " " + min + " " + max + " " + answer);
        
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
    public int[] deepCopy(int[] origin){
        int[] retArr = new int[origin.length];
        for(int i=0; i<origin.length; i++){
            retArr[i] = origin[i];
        }
        return retArr;
    }
}