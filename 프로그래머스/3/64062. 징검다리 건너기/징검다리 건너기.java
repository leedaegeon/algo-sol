import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int[] stonesArr = new int[stones.length+1];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<stones.length; i++){
            min = Math.min(min, stones[i]);
            max = Math.max(max, stones[i]);
            stonesArr[i] = stones[i];
        }
        if(min == max){
            return min;
        }
        stonesArr[stonesArr.length-1] = Integer.MAX_VALUE;
        answer = binSearch(min, max, stonesArr, k);
        
        return answer;
    }
    public int binSearch(int min, int max, int[] stones, int k){
        boolean flag = true;
        int answer = 0;
        while(min < max){
            int mid = min + (max - min)/2;
            
            int[] stonesCopy = deepCopy(stones);
            stonesCopy = jump(stonesCopy, mid);
            
            flag = check(stonesCopy, k);
            // System.out.println(flag);
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
    public boolean check(int[] stones, int k){
        boolean flag = true;
        int cnt = 0;
        for(int s: stones){
            if(s == 0){
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
    public int[] jump(int[] stones, int mid){
        for(int i=0; i<stones.length-1; i++){
            if(stones[i] < mid){
                stones[i] = 0;
            }
        }
        return stones;
    }
    public int[] deepCopy(int[] origin){
        int[] retArr = new int[origin.length];
        for(int i=0; i<origin.length; i++){
            retArr[i] = origin[i];
        }
        return retArr;
    }
}