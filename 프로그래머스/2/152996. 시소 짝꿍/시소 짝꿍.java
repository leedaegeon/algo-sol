import java.util.*;
class Solution {

    public long solution(int[] weights) {
        long answer = 0;
        int[] mul = {2, 3, 4};

        double[] dist = {2.0/2.0, 2.0/3.0, 2.0/4.0, 3.0/4.0};
        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);
        for(int w: weights){
            for(double d: dist){
                double v = w*d;
                if(map.containsKey(v)){
                    answer += map.get(v);
                }
                // System.out.println(v + " " + answer);

            }
            // System.out.println("=======================");
            map.put(w*dist[0], map.getOrDefault(w*dist[0], 0) + 1);
            
        }
        // for(double key: map.keySet()){
        //     System.out.println(key + " " +map.get(key));
        // }
        return answer;
    }

}