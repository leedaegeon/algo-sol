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
        double[] integral = new double[ls.size()];
        double[] sum = new double[ls.size()];
        
        int max = ls.size();
        for(int i=0; i<ls.size(); i++){
            if(i < ls.size()-1){
                // integral[i] =  (double)(ls.get(i) + ls.get(i+1))/2;
                sum[i] = (double)(ls.get(i) + ls.get(i+1))/2;
            }else{
                // integral[i] = (double)(ls.get(i) + 1)/2;
                sum[i] = (double)(ls.get(i) + 1)/2;
            }
            // if(i!=0){
            //     integral[i] += integral[i-1];
            // }
        }
        for(int i=0; i<ranges.length; i++){
            ranges[i][1] = max + ranges[i][1];
            if(ranges[i][0] > ranges[i][1]){
                answer[i] = -1.0;
                continue;
            }
            // if(ranges[i][0] == 0){
            //     answer[i] = integral[ranges[i][1]-1];
            // }else{
            //      answer[i] = integral[ranges[i][1]-1] - integral[ranges[i][0]-1];
            // }
            for(int start = ranges[i][0]; start < ranges[i][1]; start++){
                answer[i] += sum[start];
            }
            
        }
        
        
        return answer;
    }
}