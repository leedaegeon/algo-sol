import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> ls = new LinkedList<>();
        
        while(k>1){
            ls.add(k);
            if(k%2==0){
                k/=2;
            }else{
                k*=3;
                k+=1;
            }
        }
        ls.add(1);

        double[] sum = new double[ls.size()-1];
        int max = ls.size()-1;
        
        
        for(int i=0; i<ls.size()-1; i++){
            sum[i] = (double)(ls.get(i) + ls.get(i+1))/2;
        }
        
        for(int i=0; i<ranges.length; i++){
            ranges[i][1] = max + ranges[i][1];
            if(ranges[i][1] < ranges[i][0]){
                answer[i] = -1.0;
                continue;
            }
            for(int start = ranges[i][0]; start < ranges[i][1]; start++){
                answer[i] += (double)sum[start];
            }
        
            
        }
        
        return answer;
    }
}